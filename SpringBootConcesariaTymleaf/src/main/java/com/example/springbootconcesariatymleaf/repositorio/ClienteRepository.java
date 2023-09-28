package com.example.springbootconcesariatymleaf.repositorio;

import com.example.springbootconcesariatymleaf.model.ClienteModel;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClienteRepository {
    /*Una lista de map para almacenar los datos del cliente*/
    private Map<Long, ClienteModel> clientes;

    /*Como es en memoria necesitamos un Id generado*/

    private AtomicLong idGenerator;


}
