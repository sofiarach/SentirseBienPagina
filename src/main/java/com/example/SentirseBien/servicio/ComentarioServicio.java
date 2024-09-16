package com.example.SentirseBien.servicio;

import com.example.SentirseBien.Entidad.Cliente;
import com.example.SentirseBien.Entidad.Comentario;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ComentarioServicio {


    public List<Comentario> listarComentarios();
    public Comentario guardarComentario(Comentario c);
    public Comentario obtenerComentarioPorId(Long Id);
    public Comentario actualizarComentario(Comentario c);
    public void eliminarComentario(Long Id);
}
