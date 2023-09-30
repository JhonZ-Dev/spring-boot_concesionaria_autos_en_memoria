package com.example.springbootconcesariatymleaf.servicio;

import com.example.springbootconcesariatymleaf.model.VentasModels;
import com.example.springbootconcesariatymleaf.repositorio.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasService {
    private VentasRepository ventasRepository;
    public VentasService() {
        this.ventasRepository = new VentasRepository();
    }
    public VentasModels saveVenta(VentasModels venta) {
        return ventasRepository.saveVenta(venta);
    }
    public VentasModels getVentaById(Long id) {
        return ventasRepository.getVentaById(id);
    }

    public List<VentasModels> getAllVentas() {
        return ventasRepository.getAllVentas();
    }

}
