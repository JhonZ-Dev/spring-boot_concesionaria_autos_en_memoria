package com.example.springbootconcesariatymleaf.servicio;

import com.example.springbootconcesariatymleaf.model.AutoModels;
import com.example.springbootconcesariatymleaf.repositorio.AutoRepository;
import org.springframework.stereotype.Service;

@Service
public class AutoService {

    private AutoRepository autoRepository;
    public AutoService() {
        this.autoRepository = new AutoRepository();
    }
    public AutoModels saveAuto(AutoModels auto) {
        return autoRepository.saveAuto(auto);
    }
}
