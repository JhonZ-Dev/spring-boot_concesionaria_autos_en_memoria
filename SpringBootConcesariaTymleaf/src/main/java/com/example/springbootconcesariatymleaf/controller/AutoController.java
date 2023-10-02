package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.model.AutoModels;
import com.example.springbootconcesariatymleaf.model.ClienteModel;
import com.example.springbootconcesariatymleaf.servicio.AutoService;
import com.example.springbootconcesariatymleaf.servicio.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/nuevo")
    public String guardarAuto(@ModelAttribute("auto") AutoModels auto) {
        autoService.saveAuto(auto);
        return "redirect:/autos";
    }
    @GetMapping("/{id}")
    public String mostrarDetalleAuto(@PathVariable("id") Long id, Model model) {
        AutoModels auto = autoService.getAutoById(id);
        ClienteModel cliente = auto.getCliente();

        model.addAttribute("auto", auto);
        model.addAttribute("cliente", cliente);

        return "auto_detalle";
    }
    @GetMapping
    public String mostrarListaAutos(Model model) {
        model.addAttribute("autos", autoService.getAllAutos());
        return "auto_lista";
    }
}
