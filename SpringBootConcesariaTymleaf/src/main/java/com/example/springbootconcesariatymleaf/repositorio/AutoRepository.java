package com.example.springbootconcesariatymleaf.repositorio;

import com.example.springbootconcesariatymleaf.model.AutoModels;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AutoRepository {

    private Map<Long, AutoModels> autos;
}
