package com.example.springbootconcesariatymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/mapa")
    public String homeMapa(){
        return "mapa";

    }
    @GetMapping("/contacto")
    public String contacto(){
        return "contacto";

    }
    @GetMapping("/sobremi")
    public String sobremi(){
        return "sobremi";

    }
    @GetMapping("/ofertas")
    public String ofertas(){
        return "ofertas";

    }
    @GetMapping("/moda")
    public String moda(){
        return "moda";

    }
}
