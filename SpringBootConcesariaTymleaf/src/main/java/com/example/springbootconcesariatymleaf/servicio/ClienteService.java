package com.example.springbootconcesariatymleaf.servicio;

import com.example.springbootconcesariatymleaf.model.ClienteModel;
import com.example.springbootconcesariatymleaf.repositorio.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;
    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }
    public ClienteModel saveCliente(ClienteModel cliente) {
        return clienteRepository.saveCliente(cliente);
    }

}
