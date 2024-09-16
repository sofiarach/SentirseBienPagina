package com.example.SentirseBien.servicio;

import com.example.SentirseBien.Entidad.Cliente;
import com.example.SentirseBien.Entidad.Reserva;
import com.example.SentirseBien.repositorio.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServicioImpl implements ReservaServicio{

    @Autowired
    private ReservaRepositorio reservaRepositorio;


    @Override
    public List<Reserva> listarReservas() {
        return reservaRepositorio.findAll();
    }

    @Override
    public Reserva guardarReserva(Reserva r) {
        return reservaRepositorio.save(r);
    }

    @Override
    public Reserva obtenerReserva(Long Id) {
        return reservaRepositorio.findById(Id).get();
    }

    @Override
    public Reserva actualizarReserva(Reserva r) {
        return reservaRepositorio.save(r);
    }

    @Override
    public void eliminarReserva(Long Id) {
    reservaRepositorio.deleteById(Id);
    }
}
