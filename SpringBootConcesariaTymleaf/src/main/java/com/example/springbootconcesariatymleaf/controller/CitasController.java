package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.servicio.CitasService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/citas")
public class CitasController {

    private final CitasService citasService;
}
