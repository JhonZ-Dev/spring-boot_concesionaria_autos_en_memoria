package com.example.springbootconcesariatymleaf.repositorio;

import com.example.springbootconcesariatymleaf.model.CitasModels;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CitasRepository {

    private Map<Long, CitasModels> citas;
    private AtomicLong idGenerator;

    public CitasModels saveCita(CitasModels cita) {
        if (cita.getId() != null) {
            // La cita ya tiene un ID asignado, por lo tanto, es una actualización
            if (citas.containsKey(cita.getId())) {
                // Reemplazar la cita existente con los nuevos campos
                citas.put(cita.getId(), cita);
                return cita;
            } else {
                throw new IllegalArgumentException("Cita no encontrada para el ID: " + cita.getId());
            }
        } else {
            long id = idGenerator.incrementAndGet();
            cita.setId(id);
            citas.put(id, cita);
            return cita;
        }
    }

    public CitasModels getCitaById(Long id) {
        return citas.get(id);
    }
    public List<CitasModels> getAllCitas() {
        return new ArrayList<>(citas.values());
    }
    public CitasModels updateCita(CitasModels cita) {
        Long id = cita.getId();
        if (citas.containsKey(id)) {
            citas.put(id, cita);
            return cita;
        } else {
            return null; // Manejar caso en que la cita no existe
        }
    }
    public void deleteClienteById(Long id) {
        citas.remove(id);
    }
}
