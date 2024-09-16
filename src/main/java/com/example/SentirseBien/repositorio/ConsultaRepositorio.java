package com.example.SentirseBien.repositorio;

import com.example.SentirseBien.Entidad.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepositorio  extends JpaRepository<Consulta, Long> {
}
