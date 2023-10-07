package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.model.ClienteModel;
import com.example.springbootconcesariatymleaf.servicio.CitasService;
import com.example.springbootconcesariatymleaf.servicio.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/citas")
public class CitasController {

    private final CitasService citasService;
    private final ClienteService clienteService;

    public CitasController(CitasService citasService, ClienteService clienteService) {
        this.citasService = citasService;
        this.clienteService = clienteService;
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaCita(@RequestParam("clienteId") Long clienteId, Model model) {
        ClienteModel cliente = clienteService.getClienteById(clienteId);
        if (cliente == null) {
            return "redirect:/clientes";
        }
        model.addAttribute("cliente", cliente);
        model.addAttribute("cita", new CitasModels());
        return "formulario-cita";
    }
}
