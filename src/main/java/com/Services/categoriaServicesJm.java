package com.Services;

import java.util.List;
import com.Interfaces.Icategoria;
import com.Models.categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class categoriaServicesJm implements categoriaService {
    @Autowired
    private Icategoria icategoria;

    @Override
    public List<categoria> findAll() {
        return icategoria.findAll();
    }

}
