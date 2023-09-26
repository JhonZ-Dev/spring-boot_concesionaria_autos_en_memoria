package com.example.springbootconcesariatymleaf.model;

import lombok.Data;

@Data
public class ClienteModel {


    private long id;
    private String nombre, apellido, telefono, direccion, edad,identificacion, ciudad_residencia;


    /*Constructs*/
    public ClienteModel(){

    }

    /*Relacionar con auto*/
    /*Ya que un cliente hace la compra del auto, y el auto le pertenece al cliente*/

}
