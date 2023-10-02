package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.model.AutoModels;
import com.example.springbootconcesariatymleaf.servicio.AutoService;
import com.example.springbootconcesariatymleaf.servicio.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/autos")
public class AutoController {

    private AutoService autoService;
    private ClienteService clienteService;

    public AutoController(AutoService autoService, ClienteService clienteService) {
        this.autoService = autoService;
        this.clienteService = clienteService;
    }
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoAuto(@RequestParam("clienteId") Long clienteId, Model model) {
        AutoModels auto = new AutoModels();
        model.addAttribute("auto", auto);

        List<ClienteModel> clientes = clienteService.getAllClientes();
        if (!clientes.isEmpty()) {
            ClienteModel cliente = clientes.stream()
                    .filter(c -> c.getId().equals(clienteId))
                    .findFirst()
                    .orElse(null);

            if (cliente != null) {
                auto.setCliente(cliente);
                model.addAttribute("cliente", cliente);
            }
        }

        model.addAttribute("clientes", clientes);

        return "auto_formulario";
    }
}
