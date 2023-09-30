package com.example.springbootconcesariatymleaf.servicio;

import com.example.springbootconcesariatymleaf.repositorio.CitasRepository;
import org.springframework.stereotype.Service;

@Service
public class CitasService {
    private CitasRepository citasRepository;
    public CitasService(){
        this.citasRepository = new CitasRepository();
    }
    public CitasModels saveCita(CitasModels cita){
        return citasRepository.saveCita(cita);
    }






}
