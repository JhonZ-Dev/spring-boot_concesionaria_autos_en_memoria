package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.model.ClienteModel;
import com.example.springbootconcesariatymleaf.servicio.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

}
