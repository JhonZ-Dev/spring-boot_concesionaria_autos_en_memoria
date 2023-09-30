package com.example.springbootconcesariatymleaf.servicio;

import com.example.springbootconcesariatymleaf.repositorio.AutoRepository;
import org.springframework.stereotype.Service;

@Service
public class AutoService {

    private AutoRepository autoRepository;
    public AutoService() {
        this.autoRepository = new AutoRepository();
    }
}
