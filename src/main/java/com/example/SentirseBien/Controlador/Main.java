package com.example.SentirseBien.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class Main {
    @GetMapping("/")
    public String index(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("remoteUser", principal.getName());
        }
        return "index";
    }


    @GetMapping("/utilidades")
    public String utilidades () {

        return "utilidades";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/logout"; // Redirige al endpoint de logout de Spring Security
    }

    @GetMapping("/empleo")
    public String empleo() {
        return "empleo";  // Asegúrate de que tienes un archivo `empleo.html` en el directorio de vistas
    }



    @GetMapping("/noticias")
    public String noticias() {
        return "noticias";  // Asegúrate de que tienes un archivo `contacto.html` en el directorio de vistas
    }

    @GetMapping("/servicios")
    public String servicios() {
        System.out.println("Accediendo a la página principal");  // Mensaje de debug

        return "servicios";  // Renderiza la página principal (asegúrate de tener un archivo index.html o equivalente)
    }
}
