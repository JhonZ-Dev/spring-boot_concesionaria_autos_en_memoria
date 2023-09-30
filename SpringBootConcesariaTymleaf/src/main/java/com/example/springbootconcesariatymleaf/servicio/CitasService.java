package com.example.springbootconcesariatymleaf.servicio;

import com.example.springbootconcesariatymleaf.model.CitasModels;
import com.example.springbootconcesariatymleaf.repositorio.CitasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitasService {
    private CitasRepository citasRepository;
    public CitasService(){
        this.citasRepository = new CitasRepository();
    }
    public CitasModels saveCita(CitasModels cita){
        return citasRepository.saveCita(cita);
    }
    public CitasModels getCitaById(Long id){
        return citasRepository.getCitaById(id);
    }
    public List<CitasModels> getAllCitas(){
        return citasRepository.getAllCitas();
    }
    public CitasModels updateCita(CitasModels cita){
        return citasRepository.updateCita(cita);
    }
    public void deleteClienteById(Long id){
        citasRepository.deleteClienteById(id);
    }




}
