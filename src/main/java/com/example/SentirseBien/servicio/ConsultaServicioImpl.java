package com.example.SentirseBien.servicio;

import com.example.SentirseBien.Entidad.Consulta;
import com.example.SentirseBien.repositorio.ConsultaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServicioImpl implements ConsultaServicio{

    @Autowired
    private ConsultaRepositorio consultaRepositorio;

    @Override
    public List<Consulta> listarConsultas() {
        return consultaRepositorio.findAll();
    }

    @Override
    public Consulta guardarConsulta(Consulta c) {
        return consultaRepositorio.save(c);
    }

    @Override
    public Consulta obtenerConsultaPorId(Long Id) {
        return consultaRepositorio.findById(Id).get();
    }

    @Override
    public Consulta actualizarConsulta(Consulta c) {
        return consultaRepositorio.save(c);
    }

    @Override
    public void eliminarConsulta(Long Id) {
        consultaRepositorio.deleteById(Id);
    }
}
