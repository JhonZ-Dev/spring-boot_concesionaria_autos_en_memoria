package com.example.springbootconcesariatymleaf.repositorio;

import com.example.springbootconcesariatymleaf.model.ClienteModel;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ClienteRepository {
    /*Una lista de map para almacenar los datos del cliente*/
    private Map<Long, ClienteModel> clientes;
}
