package com.example.SentirseBien.repositorio;

import com.example.SentirseBien.Entidad.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
Empleado findByEmail(String email);
}
