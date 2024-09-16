package com.example.SentirseBien.servicio;

import com.example.SentirseBien.Entidad.Consulta;

import java.util.List;

public interface ConsultaServicio {


    public List<Consulta> listarConsultas();
    public Consulta guardarConsulta(Consulta c);
    public Consulta obtenerConsultaPorId(Long Id);
    public Consulta actualizarConsulta(Consulta c);
    public void eliminarConsulta(Long Id);
}
