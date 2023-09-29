package com.example.springbootconcesariatymleaf.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class VentasModels {

    private Long id;
    private LocalDate fecha_venta;
    private double precio;
    private AutoModels auto;


    private ClienteModel cliente;
}
