package com.example.SentirseBien.servicio;

import com.example.SentirseBien.Entidad.Cliente;
import com.example.SentirseBien.Entidad.Reserva;

import java.util.List;

public interface ReservaServicio {

    public List<Reserva> listarReservas();
    public Reserva guardarReserva(Reserva r);
    public Reserva obtenerReserva(Long Id);
    public Reserva actualizarReserva(Reserva r);
    public void eliminarReserva(Long Id);
}
