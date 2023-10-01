package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.servicio.VentasService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller

public class VentasController_PDF {
    @Autowired
    private VentasService ventasService;

    public void generarPDF(@PathVariable("id") Long ventaId, HttpServletResponse response) throws IOException {

        
    }
}
