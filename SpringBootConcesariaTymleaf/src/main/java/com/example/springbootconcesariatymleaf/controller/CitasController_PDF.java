package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.model.CitasModels;
import com.example.springbootconcesariatymleaf.servicio.CitasService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEvent;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class CitasController_PDF {
    @Autowired
    private CitasService citasService;

    @RequestMapping(value = "/cita/{id}/pdf", method = RequestMethod.GET)
    public void generarPDF(@PathVariable("id")Long citaId,
                           HttpServletResponse response) throws IOException{

        CitasModels citasModels = citasService.getCitaById(citaId);
        Document document = new Document(PageSize.A4.rotate());

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"cita-" + citaId + ".pdf\"");
        OutputStream outputStream = response.getOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);

        writer.setPageEvent(new PdfPageEventHelper(){
            public void onStartPage(PdfWriter writer, Document document){
                try {
                    PdfPTable headerTable = new PdfPTable(2);
                    headerTable.setWidthPercentage(100);
                    document.add(headerTable);
                    document.add(new Paragraph("\n"));


                }catch (
                        Exception e
                ){
                    e.printStackTrace();
                }
            }
        });
        document.open();
        // Estilos de colores para las columnas y filas
        Color colorColumnas = new Color(255, 191, 0); // Color gris claro para las columnas
        Color colorFilas = new Color(255, 255, 255); // Color gris claro para las filas

        // Agregar contenido al documento PDF
        Paragraph paragraph = new Paragraph("DETALLE DE LA CITA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        // Agregar tabla con los datos de la cita
        PdfPTable table = new PdfPTable(4); // 4 columnas para ID, fecha estimada, hora estimada y cliente
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f); // Espacio antes de la tabla
        // Establecer colores de las columnas
        table.getDefaultCell().setBackgroundColor(colorColumnas);

    }
}
