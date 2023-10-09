package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.servicio.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CitasController_PDF {
    @Autowired
    private CitasService citasService;

    @RequestMapping(value = "/cita/{id}/pdf", method = RequestMethod.GET)
    
}
