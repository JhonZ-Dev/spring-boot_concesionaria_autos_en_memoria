package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.model.ClienteModel;
import com.example.springbootconcesariatymleaf.servicio.ClienteService;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.*;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;

import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /*Metodo para guardar un cliente*/
    /*Este es para la vista*/
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoCliente(Model model) {
        model.addAttribute("cliente", new ClienteModel());
        return "cliente_formulario";
    }

    /*Para el envio de un nuevo cliente*/
    @PostMapping("/nuevo")
    public String guardarCliente(@ModelAttribute("cliente") ClienteModel cliente, Model model) {
        String identificacion = cliente.getIdentificacion();

        boolean existeCedula = clienteService.existeClienteConCedula(identificacion);
        if (existeCedula) {
            model.addAttribute("existeCedula", true);
            return "/cliente_formulario"; // Nombre de la vista del formulario
        }
        clienteService.saveCliente(cliente);
        return "redirect:/clientes";
    }

    /*Utilizaremos un solitud ajax para validar la celular, cedula, etc*/
    @GetMapping("/verificar-cedula")
    @ResponseBody
    public boolean verificarCedula(@RequestParam("identificacion") String identificacion) {
        return clienteService.existeClienteConCedula(identificacion);
    }

    @GetMapping("/verificar-telefono")
    public boolean verificarTelefono(@RequestParam("telefono") String telefono) {
        return clienteService.existeClienteConTelefono(telefono);
    }
    @GetMapping("/{id}")
    public String mostrarDetalleCliente(@PathVariable("id") Long id, Model model) {
        ClienteModel cliente = clienteService.getClienteById(id);
        model.addAttribute("cliente", cliente);
        return "cliente_detalle";
    }

    @GetMapping
    public String mostrarListaClientes(Model model) {
        model.addAttribute("clientes", clienteService.getAllClientes());
        return "cliente_lista";
    }

    /*Esto para generar un pdf*/
    @GetMapping("/generar-pdf")
    public void generarPDFClientes(HttpServletResponse response) throws IOException, DocumentException {
        // Obtén la lista de clientes
        List<ClienteModel> clientes = clienteService.getAllClientes();

        Document document = new Document();

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"clientes.pdf\"");

        OutputStream outputStream = response.getOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);

        document.open();
        Image imagen = Image.getInstance(VentasController_PDF.class.getClassLoader().getResource("static/imagenes/auto.png"));
        imagen.setAlignment(Element.ALIGN_CENTER);
        document.add(imagen);

        // Agregar contenido al documento PDF
        Paragraph paragraph = new Paragraph("Lista de Clientes");

        // Establecer fuente personalizada para el texto del título
        com.lowagie.text.Font fuenteTitulo = FontFactory.getFont("Helvetica_BOLD", 26, Font.BOLD);
        paragraph.setFont(fuenteTitulo);

        // Agregar espaciado antes y después del párrafo
        paragraph.setSpacingBefore(20);
        paragraph.setSpacingAfter(20);

        // Alinear el párrafo al centro
        paragraph.setAlignment(Element.ALIGN_CENTER);

        document.add(paragraph);

        // Agregar tabla con datos de los clientes
        PdfPTable table = new PdfPTable(3); // 3 columnas para ID, nombre y correo electrónico
        table.setWidthPercentage(100);

        // Establecer estilos de las columnas
        PdfPCell headerCell = new PdfPCell();
        headerCell.setBackgroundColor(Color.RED);
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        headerCell.setPadding(5);

        // Establecer fuente negrita para los encabezados de las columnas
        com.lowagie.text.Font fuenteEncabezado = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, Color.WHITE);
        headerCell.setPhrase(new Phrase("ID", fuenteEncabezado));
        table.addCell(headerCell);

        headerCell.setPhrase(new Phrase("Nombre", fuenteEncabezado));
        table.addCell(headerCell);

        headerCell.setPhrase(new Phrase("Telefono", fuenteEncabezado));
        table.addCell(headerCell);

        // Establecer estilos de las filas
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.YELLOW);
        cell.setPadding(5);

        // Establecer fuente personalizada para las celdas de los datos
        com.lowagie.text.Font fuenteDatos = FontFactory.getFont("Arial", 10, Color.BLACK);

        for (ClienteModel cliente : clientes) {
            // Establecer estilo de la celda de la fila
            table.getDefaultCell().setBackgroundColor(Color.YELLOW);

            // Establecer fuente personalizada para los datos de la fila
            table.addCell(new Phrase(cliente.getId().toString(), fuenteDatos));
            table.addCell(new Phrase(cliente.getNombre(), fuenteDatos));
            table.addCell(new Phrase(cliente.getTelefono(), fuenteDatos));
        }

        document.add(table);

        document.add(new Paragraph("\n"));

        Paragraph footer_2 = new Paragraph("Grand Theft Auto es una concesionaria excepcional que ha establecido un estándar notable en la industria automotriz. Con su dedicación inquebrantable a la calidad y la excelencia en el servicio al cliente, GRAND THEFT AUTO se ha ganado una reputación envidiable. Su amplio catálogo de vehículos de alta gama y su atención meticulosa a los detalles hacen que cada visita a sus instalaciones sea una experiencia inigualable.", FontFactory.getFont(FontFactory.HELVETICA, 12));
        footer_2.setAlignment(Element.ALIGN_JUSTIFIED);
        document.add(footer_2);

        // Cerrar el documento PDF
        document.close();
        writer.close();
    }

}
