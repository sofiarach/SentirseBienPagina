package com.example.SentirseBien.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginControlador {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Esto debe coincidir con el nombre de tu archivo .html en templates
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password) {
        // Lógica para manejar el inicio de sesión
        // Validar el usuario y contraseña
        // Redirigir según el resultado de la autenticación

        return "redirect:/home"; // Redirige a la página de inicio o a una página de éxito
    }
}
