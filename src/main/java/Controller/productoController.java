package Controller;

import java.util.List;

import com.Models.categoria;
import com.Models.producto;
import com.Services.categoriaService;
import com.Services.productoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/productos")
public class productoController {

    @Autowired
    private productoService productoservice;

    @Autowired
    private categoriaService categoriasservice;

    @GetMapping("/categorias")
    public ResponseEntity<List<categoria>> ListarCategorias() {
        return new ResponseEntity<>(categoriasservice.findAll(), HttpStatus.OK);

    }

    @GetMapping("/listar")
    public ResponseEntity<List<producto>> ListarProducto() {
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);

    }

    @PostMapping("/crear")
    public ResponseEntity<producto> crearProducto(@RequestBody producto producto) {
        return new ResponseEntity<>(productoservice.save(producto), HttpStatus.CREATED);
    }

    /*
     * @PutMapping("/actualizar/{id}")
     * public ResponseEntity<producto> actualizarProducto(PathVariable Long
     * id, @RequestBody producto producto){
     * 
     * Producto productoEncontrado = productoService.findById(id);
     * 
     * if(productoEncontrado == null){
     * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     * }
     * try{
     * productoEncontrado.setNombre(producto.getNombre());
     * productoEncontrado.setPrecio(producto.getPrecio());
     * productoEncontrado.setImagen(producto.getImagen());
     * productoEncontrado.setCategoria(producto.getCategoria());
     * return new ResponseEntity<>(productoservice.save(productoEncontrado),
     * HttpStatus.CREATED);
     * }catch(DataAccessException e){
     * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Long id) {
        productoservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
