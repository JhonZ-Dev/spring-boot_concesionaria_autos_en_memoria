package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.model.CitasModels;
import com.example.springbootconcesariatymleaf.model.ClienteModel;
import com.example.springbootconcesariatymleaf.servicio.CitasService;
import com.example.springbootconcesariatymleaf.servicio.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/nueva")
    public String guardarCita(@ModelAttribute("cita") CitasModels cita, @RequestParam("clienteId") Long clienteId) {
        ClienteModel cliente = clienteService.getClienteById(clienteId);
        if (cliente != null) {
            if (cita.getId() != null) {
                // La cita ya tiene un ID, por lo que se trata de una actualización
                CitasModels citaExistente = citasService.getCitaById(cita.getId());
                if (citaExistente != null) {
                    // Actualizar los campos de la cita existente con los datos de la cita actualizada
                    citaExistente.setFecha_estimada(cita.getFecha_estimada());
                    citaExistente.setHora_estimada(cita.getHora_estimada());
                    citaExistente.setCliente(cliente);
                    citasService.saveCita(citaExistente);
                }
            } else {
                // La cita no tiene un ID, por lo que se trata de una nueva cita
                cita.setCliente(cliente);
                citasService.saveCita(cita);
            }
        }
        return "redirect:/citas";
    }

    @GetMapping("")
    public String mostrarListaCitas(Model model) {
        List<CitasModels> citas = citasService.getAllCitas();
        model.addAttribute("citas", citas);
        return "lista-citas";
    }

    @GetMapping("/{id}")
    public String mostrarCitaPorId(@PathVariable("id") Long id, Model model) {
        CitasModels cita = citasService.getCitaById(id);
        if (cita == null) {
            return "redirect:/citas";
        }
        model.addAttribute("cita", cita);
        return "detalle-cita";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditarCita(@PathVariable("id") Long id, Model model) {
        CitasModels cita = citasService.getCitaById(id);
        if (cita == null) {
            return "redirect:/citas";
        }
        model.addAttribute("cita", cita);
        return "formulario-editar-cita";
    }
    @PostMapping("/{id}/editar")
    public String actualizarCita(@PathVariable("id") Long id, @ModelAttribute("cita") CitasModels citaActualizada) {
        CitasModels citaExistente = citasService.getCitaById(id);

        if (citaExistente == null) {
            // Manejar caso en que la cita no existe
            return "redirect:/citas";
        }

        // Actualizar los campos de la cita existente con los datos actualizados
        citaExistente.setFecha_estimada(citaActualizada.getFecha_estimada());
        citaExistente.setHora_estimada(citaActualizada.getHora_estimada());

        // Guardar la cita actualizada en la base de datos
        citasService.saveCita(citaExistente);

        // Redirigir a la lista de citas
        return "redirect:/citas";
    }
}
