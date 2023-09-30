package com.example.springbootconcesariatymleaf.servicio;

import com.example.springbootconcesariatymleaf.repositorio.VentasRepository;
import org.springframework.stereotype.Service;

@Service
public class VentasService {
    private VentasRepository ventasRepository;
    public VentasService() {
        this.ventasRepository = new VentasRepository();
    }
    public VentasModels saveVenta(VentasModels venta) {
        return ventasRepository.saveVenta(venta);
    }


}
