package com.example.SentirseBien.Controlador;

import com.example.SentirseBien.Entidad.Reserva;
import com.example.SentirseBien.servicio.ReservaServicio;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;

@Controller
public class ReservaControlador {

    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping({"/reservas"})
    public String listarReservas(Model modelo) {
        modelo.addAttribute("reservas", reservaServicio.listarReservas());
        return "reservas";
    }

    @GetMapping({"/hacerreserva"})
    public String mostrarFormReserva(Model modelo) {
        Reserva new_reserva = new Reserva();
        modelo.addAttribute("reservas", new_reserva);
        return "crear_reservas";
    }

    @PostMapping("/reserva")
    public ResponseEntity<byte[]> guardarReserva(@ModelAttribute("reservas") Reserva reserva) {
        // Guardar la reserva en la base de datos
        reservaServicio.guardarReserva(reserva);

        // Crear el documento PDF
        try {
            // Crear un documento PDF
            Document document = new Document();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, out);

            document.open();

            // Agregar contenido al PDF con los datos de la reserva
            document.add(new Paragraph("Detalles de la Reserva"));
            document.add(new Paragraph("Nombre del Cliente: " + reserva.getNombreCliente()));
            document.add(new Paragraph("Fecha de la Reserva: " + reserva.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))));
            document.add(new Paragraph("Servicio: " + reserva.getServicio()));

            document.close();

            // Configurar las cabeceras HTTP para descargar el archivo PDF
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "reserva_" + reserva.getNombreCliente() + ".pdf");

            // Retornar el PDF como respuesta
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(out.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
