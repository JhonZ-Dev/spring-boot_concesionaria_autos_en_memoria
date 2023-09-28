package com.example.springbootconcesariatymleaf.repositorio;

import com.example.springbootconcesariatymleaf.model.AutoModels;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AutoRepository {

    private Map<Long, AutoModels> autos;
    private AtomicLong idGenerator;

    public AutoRepository() {
        this.autos = new HashMap<>();
        this.idGenerator = new AtomicLong(0);
    }
}
