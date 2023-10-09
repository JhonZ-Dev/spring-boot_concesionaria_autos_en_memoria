package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.model.CitasModels;
import com.example.springbootconcesariatymleaf.servicio.CitasService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class CitasController_PDF {
    @Autowired
    private CitasService citasService;

    @RequestMapping(value = "/cita/{id}/pdf", method = RequestMethod.GET)
    public void generarPDF(@PathVariable("id")Long citaId,
                           HttpServletResponse response) throws IOException{

        CitasModels citasModels = citasService.getCitaById(citaId);
    }
}
