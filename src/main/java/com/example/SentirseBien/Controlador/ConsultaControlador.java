package com.example.SentirseBien.Controlador;

import com.example.SentirseBien.Entidad.Consulta;
import com.example.SentirseBien.Entidad.Empleado;
import com.example.SentirseBien.servicio.ConsultaServicio;
import com.example.SentirseBien.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConsultaControlador {

    @Autowired
    private ConsultaServicio consultaServicio;

    @GetMapping({"/consulta"})
    public String listarConsultas(Model modelo){
        modelo.addAttribute("consultas",consultaServicio.listarConsultas());
        return "consultas";
    }

    @GetMapping({"/consulta/nuevo"})
    public String mostrarFormRegistroConsulta(Model modelo){
        Consulta new_consulta = new Consulta();
        modelo.addAttribute("consultas",new_consulta);
        return "crear_consulta";
    }

    @PostMapping("/consulta")
    public String guardarConsulta(@ModelAttribute("consultas")Consulta consulta) {
        consulta.setRespuesta("En breve Responderemos");
        consultaServicio.guardarConsulta(consulta);
        return "redirect:/consulta";

    }

    @GetMapping("/consulta/editar/{id}")
    public String mostrarFormEditarConsulta(@PathVariable Long id, Model modelo){
        modelo.addAttribute("consulta", consultaServicio.obtenerConsultaPorId(id));
        return "editar_consulta";
    }

    @PostMapping("/consulta/{id}")
    public String actualizarConsulta(@PathVariable Long id, @ModelAttribute("consulta") Consulta consulta, Model modelo){
        Consulta consultaExistente = consultaServicio.obtenerConsultaPorId(id);
        consultaExistente.setId(id);
        consultaExistente.setNombre(consulta.getNombre());
        consultaExistente.setEmail(consulta.getEmail());
        consultaExistente.setRespuesta(consulta.getRespuesta());


        consultaServicio.actualizarConsulta(consultaExistente);
        return "redirect:/consulta";

    }

    @GetMapping("/consulta/{id}")
    public String eliminarEmpleado(@PathVariable Long id){
        consultaServicio.eliminarConsulta(id);
        return "redirect:/consulta";
    }



}
