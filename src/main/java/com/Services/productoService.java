package com.Services;

import java.util.List;
import com.Models.producto;

public interface productoService {

    public producto save(producto producto);

    public producto findById(Long id);

    public static List<producto> findAll() {
        return null;
    }

    public void delete(Long id);

}
