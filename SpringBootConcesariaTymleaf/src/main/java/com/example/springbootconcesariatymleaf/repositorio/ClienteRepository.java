package com.example.springbootconcesariatymleaf.repositorio;

import com.example.springbootconcesariatymleaf.model.ClienteModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClienteRepository {
    /*Una lista de map para almacenar los datos del cliente*/
    private Map<Long, ClienteModel> clientes;

    /*Como es en memoria necesitamos un Id generado*/

    private AtomicLong idGenerator;

    /*Su consutructor*/
    public ClienteRepository() {
        this.clientes = new HashMap<>();
        this.idGenerator = new AtomicLong(0);
    }

    /*Guardar*/
    public ClienteModel saveCliente(ClienteModel cliente) {
        long id = idGenerator.incrementAndGet();
        cliente.setId(id);
        clientes.put(id, cliente);
        return cliente;
    }


}
