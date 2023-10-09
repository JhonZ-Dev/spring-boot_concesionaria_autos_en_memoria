package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.servicio.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CitasController_PDF {
    @Autowired
    private CitasService citasService;
}
