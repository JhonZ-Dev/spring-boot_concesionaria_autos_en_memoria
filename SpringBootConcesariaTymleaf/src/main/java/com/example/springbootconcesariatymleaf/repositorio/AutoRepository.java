package com.example.springbootconcesariatymleaf.repositorio;

import com.example.springbootconcesariatymleaf.model.AutoModels;
import com.example.springbootconcesariatymleaf.model.ClienteModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AutoRepository {

    private Map<Long, AutoModels> autos;
    private AtomicLong idGenerator;

    public AutoRepository() {
        this.autos = new HashMap<>();
        this.idGenerator = new AtomicLong(0);
    }

    /*GUARDAR*/
    public AutoModels saveAuto(AutoModels auto){
        if(auto.getId() !=null){
            // El auto ya tiene un ID asignado, por lo tanto, es una actualización
            if(autos.containsKey(auto.getId())){
                //Reeplazar el auto existente con los nuevos campos
                autos.put(auto.getId(), auto);
                return auto;
            }else{
                throw new IllegalArgumentException("Cliente no encontrado para el ID: " + auto.getId());
            }
        }else{
            long id = idGenerator.incrementAndGet();
            auto.setId(id);
            autos.put(id, auto);
            return auto;
        }
    }
    public AutoModels getAutoById(Long id) {
        AutoModels auto = autos.get(id);
        ClienteModel cliente = auto.getCliente();
        auto.setCliente(cliente); // Asignar el cliente al auto
        return auto;
    }

    public List<AutoModels> getAllAutos() {
        return new ArrayList<>(autos.values());
    }

    public void eliminarAuto(Long id) {
        autos.remove(id);
    }
}
