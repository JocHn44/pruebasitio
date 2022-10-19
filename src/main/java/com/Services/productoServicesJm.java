package com.Services;

import java.util.List;

import com.Interfaces.Iproducto;
import com.Models.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productoServicesJm implements productoService {

    @Autowired
    private Iproducto Iproducto;

    @Override
    public producto save(producto producto) {
        return Iproducto.save(producto);
    }

    @Override
    public producto findById(Long id) {
        return Iproducto.findById(id).orElse(null);
    }

    public List<producto> findAll() {
        return Iproducto.findAll();
    }

    @Override
    public void delete(Long id) {
        Iproducto.deleteById(id);

    }

}
