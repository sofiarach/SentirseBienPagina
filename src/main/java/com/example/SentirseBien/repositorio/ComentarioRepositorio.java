package com.example.SentirseBien.repositorio;

import com.example.SentirseBien.Entidad.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, Long> {
}
