package com.example.springbootconcesariatymleaf.repositorio;

import com.example.springbootconcesariatymleaf.model.VentasModels;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class VentasRepository {
    private Map<Long, VentasModels> ventas;
    private AtomicLong idGenerator;
    public VentasRepository() {
        this.ventas = new HashMap<>();
        this.idGenerator = new AtomicLong(0);
    }


    public VentasModels saveVenta(VentasModels venta) {
        if (venta.getId() != null) {
            // La venta ya tiene un ID asignado, por lo tanto, es una actualización
            if (ventas.containsKey(venta.getId())) {
                // Reemplazar la venta existente con los nuevos campos
                ventas.put(venta.getId(), venta);
                return venta;
            } else {
                throw new IllegalArgumentException("Venta no encontrada para el ID: " + venta.getId());
            }
        } else {
            long id = idGenerator.incrementAndGet();
            venta.setId(id);
            ventas.put(id, venta);
            return venta;
        }
    }
    public VentasModels getVentaById(Long id) {
        return ventas.get(id);
    }
    public List<VentasModels> getAllVentas() {
        return new ArrayList<>(ventas.values());
    }
    public void deleteClienteById(Long id) {
        ventas.remove(id);
    }
}
