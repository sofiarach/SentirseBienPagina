package com.example.SentirseBien.Controlador;


import com.example.SentirseBien.Entidad.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.SentirseBien.servicio.EmpleadoServicio;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadoControlador {

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping({"/empleado"})
    public String listarEmpleados(Model modelo){
        modelo.addAttribute("empleados",empleadoServicio.listarEmpleados());
        return "empleados";
    }

    @GetMapping({"/empleado/nuevo"})
    public String mostrarFormRegistroEmpleado(Model modelo){
        Empleado new_empleado = new Empleado();
        modelo.addAttribute("empleados",new_empleado);
        return "crear_empleados";
    }

    @PostMapping("/empleado")
    public String guardarEmpleado(@ModelAttribute("empleados")Empleado empleado) {
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/empleado";

    }

    @GetMapping("/empleado/editar/{id}")
    public String mostrarFormEditarEmpleado(@PathVariable Long id, Model modelo){
        modelo.addAttribute("empleado", empleadoServicio.obtenerEmpleadoPorId(id));
        return "editar_empleado";
    }

    @PostMapping("/empleado/{id}")
    public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute("empleado") Empleado empleado, Model modelo){
        Empleado empleadoExistente = empleadoServicio.obtenerEmpleadoPorId(id);
        empleadoExistente.setId_empleado(id);
        empleadoExistente.setNombre(empleado.getNombre());
        empleadoExistente.setApellido(empleado.getApellido());
        empleadoExistente.setEmail(empleado.getEmail());
        empleadoExistente.setTelefono(empleado.getTelefono());

        empleadoServicio.actualizarEmpleado(empleadoExistente);
        return "redirect:/empleado";

    }

    @GetMapping("/empleado/{id}")
    public String eliminarEmpleado(@PathVariable Long id){
        empleadoServicio.eliminarEmpleado(id);
        return "redirect:/empleado";
    }


}
