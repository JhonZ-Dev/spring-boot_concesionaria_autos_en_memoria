package com.example.springbootconcesariatymleaf.repositorio;

import com.example.springbootconcesariatymleaf.model.CitasModels;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CitasService {

    private Map<Long, CitasModels> citas;
}
