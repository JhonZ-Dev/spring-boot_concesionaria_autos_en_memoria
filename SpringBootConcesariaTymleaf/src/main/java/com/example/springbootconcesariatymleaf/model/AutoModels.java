package com.example.springbootconcesariatymleaf.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutoModels {
    private Long id;
    private String modelo;
    private String marca;
    private String anio;
    private String color;
    private byte[] imagen;

    /*Relaciones - apesar que esta en memoria es necesario colocar relaciones*/

}
