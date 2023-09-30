package com.example.springbootconcesariatymleaf.servicio;

import com.example.springbootconcesariatymleaf.model.AutoModels;
import com.example.springbootconcesariatymleaf.repositorio.AutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {

    private AutoRepository autoRepository;
    public AutoService() {
        this.autoRepository = new AutoRepository();
    }
    public AutoModels saveAuto(AutoModels auto) {
        return autoRepository.saveAuto(auto);
    }
    public AutoModels getAutoById(Long id) {
        return autoRepository.getAutoById(id);
    }
    public List<AutoModels> getAllAutos() {
        return autoRepository.getAllAutos();
    }
}
