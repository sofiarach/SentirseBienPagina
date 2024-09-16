package com.example.SentirseBien.Controlador;


import com.example.SentirseBien.Entidad.Comentario;


import com.example.SentirseBien.servicio.ComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class ComentarioControlador {

    @Autowired
    private ComentarioServicio comentarioServicio;

    @GetMapping({"/contacto"})
    public String listarComentarios(Model modelo){
        modelo.addAttribute("comentarios",comentarioServicio.listarComentarios());
        return "contacto";
    }

    @GetMapping({"/comentario/nuevo"})
    public String mostrarFormRegistroComentarios(Model modelo){
        Comentario new_comentario = new Comentario();
        modelo.addAttribute("comentarios",new_comentario);
        return "crear_comentarios";
    }

    @PostMapping("/contacto")
    public String guardarComentario(@ModelAttribute("comentarios")Comentario comentario) {
        comentarioServicio.guardarComentario(comentario);
        return "redirect:/contacto";

    }


    @GetMapping("/comentario/{id}")
    public String eliminarComentario(@PathVariable Long id){
        comentarioServicio.eliminarComentario(id);
        return "redirect:/contacto";
    }


}
