package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.servicio.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /*Metodo para guardar un cliente*/
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoCliente(Model model) {
        model.addAttribute("cliente", new ClienteModel());
        return "cliente_formulario";
    }

}
