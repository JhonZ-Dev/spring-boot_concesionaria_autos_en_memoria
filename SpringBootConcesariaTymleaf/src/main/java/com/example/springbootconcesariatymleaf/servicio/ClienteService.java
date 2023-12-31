package com.example.springbootconcesariatymleaf.servicio;

import com.example.springbootconcesariatymleaf.model.ClienteModel;
import com.example.springbootconcesariatymleaf.repositorio.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;
    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }
    public ClienteModel saveCliente(ClienteModel cliente) {
        return clienteRepository.saveCliente(cliente);
    }
    public ClienteModel getClienteById(Long id) {
        return clienteRepository.getClienteById(id);
    }
    public List<ClienteModel> getAllClientes() {
        return clienteRepository.getAllClientes();
    }
    public void deleteClienteById(Long id) {
        clienteRepository.deleteClienteById(id);
    }
    public ClienteModel findByIdentificacion(String identificacion){
        return  clienteRepository.findByIdentificacion(identificacion);
    }
    public boolean existeClienteConCedula(String identificacion){
        return clienteRepository.existeClienteConCedula(identificacion);
    }
    public boolean existeClienteConTelefono(String telefono){
        return clienteRepository.existeClienteConTelefono(telefono);
    }
    
}
