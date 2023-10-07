package com.example.springbootconcesariatymleaf.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.ConstructorProperties;
import java.time.LocalDate;

@Data


public class CitasModels {

    private Long id;
    private LocalDate fecha_estimada;
    private String hora_estimada;
    private ClienteModel cliente;



    public CitasModels(){

    }

}
