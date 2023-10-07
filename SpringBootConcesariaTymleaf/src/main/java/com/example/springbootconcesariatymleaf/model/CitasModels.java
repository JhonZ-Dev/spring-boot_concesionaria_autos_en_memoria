package com.example.springbootconcesariatymleaf.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor

public class CitasModels {

    private Long id;
    private LocalDate fecha_estimada;
    private String hora_estimada;
    private AutoModels auto;


    public CitasModels(){

    }

}
