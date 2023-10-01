package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.model.VentasModels;
import com.example.springbootconcesariatymleaf.servicio.VentasService;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
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

        // Obtén la venta según el ID proporcionado
        VentasModels venta = ventasService.getVentaById(ventaId);
        Document document = new Document(PageSize.LETTER); // Establecer tamaño de página a carta

    }
}
