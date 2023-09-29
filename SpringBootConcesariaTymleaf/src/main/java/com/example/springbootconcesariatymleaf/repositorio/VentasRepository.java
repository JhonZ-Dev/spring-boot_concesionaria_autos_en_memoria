package com.example.springbootconcesariatymleaf.repositorio;

import com.example.springbootconcesariatymleaf.model.VentasModels;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class VentasRepository {
    private Map<Long, VentasModels> ventas;
    private AtomicLong idGenerator;
}
