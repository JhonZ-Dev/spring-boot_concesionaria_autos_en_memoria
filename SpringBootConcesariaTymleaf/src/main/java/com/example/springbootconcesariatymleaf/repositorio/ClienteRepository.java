package com.example.springbootconcesariatymleaf.repositorio;

import com.example.springbootconcesariatymleaf.model.ClienteModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        if (cliente.getId() != null) {
            // El cliente ya tiene un ID asignado, por lo tanto, es una actualización
            if (clientes.containsKey(cliente.getId())) {
                // Reemplazar el cliente existente con los nuevos datos
                clientes.put(cliente.getId(), cliente);
                return cliente;
            } else {
                // Manejar el caso en el que el cliente con el ID proporcionado no existe
                throw new IllegalArgumentException("Cliente no encontrado para el ID: " + cliente.getId());
            }
        } else {
            // El cliente no tiene un ID asignado, por lo tanto, es un nuevo cliente a crear
            long id = idGenerator.incrementAndGet();
            cliente.setId(id);
            clientes.put(id, cliente);
            return cliente;
        }
    }

    /*Obtener cliente por ID*/
    public ClienteModel getClienteById(Long id) {
        return clientes.get(id);
    }

    /*Obtener todos*/
    public List<ClienteModel> getAllClientes() {
        return new ArrayList<>(clientes.values());
    }

    /*Elimar por id*/
    public void deleteClienteById(Long id) {
        clientes.remove(id);
    }

    


}
