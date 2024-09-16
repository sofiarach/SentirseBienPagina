package com.example.SentirseBien.Controlador;


import com.example.SentirseBien.Entidad.Cliente;
import com.example.SentirseBien.Entidad.Empleado;
import com.example.SentirseBien.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping({"/cliente"})
    public String listarClientes(Model modelo) {
        modelo.addAttribute("clientes", clienteServicio.listarCliente());
        return "clientes";  // Asegúrate de que existe una plantilla llamada "clientes.html".
    }

    @GetMapping({"/cliente/nuevo"})
    public String mostrarFormRegistroCliente(Model modelo) {
        Cliente new_cliente = new Cliente();
        modelo.addAttribute("cliente", new_cliente); // Asegúrate de que se llama "cliente"
        return "crear_clientes";  // Asegúrate de que existe la plantilla "crear_clientes.html"
    }

    @PostMapping("/cliente")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteServicio.guardarCliente(cliente);
        return "redirect:/";
    }

    @GetMapping("/cliente/editar/{id}")
    public String mostrarFormEditarCliente(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("cliente", clienteServicio.obtenerEmpleadoPorId(id));
        return "editar_clientes"; // Asegúrate de que existe la plantilla "editar_cliente.html"
    }

    @PostMapping("/cliente/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {
        Cliente clienteExistente = clienteServicio.obtenerEmpleadoPorId(id);
        clienteExistente.setClienteId(id);
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setTelefono(cliente.getTelefono());

        clienteServicio.actualizarCliente(clienteExistente);
        return "redirect:/cliente";
    }

    @GetMapping("/cliente/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteServicio.eliminarCliente(id);
        return "redirect:/cliente";
    }
}
