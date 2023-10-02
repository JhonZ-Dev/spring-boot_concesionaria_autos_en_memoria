package com.example.springbootconcesariatymleaf.controller;

import com.example.springbootconcesariatymleaf.servicio.AutoService;
import com.example.springbootconcesariatymleaf.servicio.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/autos")
public class AutoController {

    private AutoService autoService;
    private ClienteService clienteService;
}
