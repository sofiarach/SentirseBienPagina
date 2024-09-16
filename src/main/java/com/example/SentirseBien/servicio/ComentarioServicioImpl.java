package com.example.SentirseBien.servicio;

import com.example.SentirseBien.Entidad.Comentario;
import com.example.SentirseBien.repositorio.ComentarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComentarioServicioImpl implements ComentarioServicio{
    @Autowired
    private ComentarioRepositorio comentarioRepositorio;
    @Override
    public List<Comentario> listarComentarios() {
        return comentarioRepositorio.findAll();
    }

    @Override
    public Comentario guardarComentario(Comentario c) {
        return comentarioRepositorio.save(c);
    }

    @Override
    public Comentario obtenerComentarioPorId(Long Id) {
        return comentarioRepositorio.findById(Id).get();
    }

    @Override
    public Comentario actualizarComentario(Comentario c) {
        return comentarioRepositorio.save(c);
    }

    @Override
    public void eliminarComentario(Long Id) {
        comentarioRepositorio.deleteById(Id);
    }
}
