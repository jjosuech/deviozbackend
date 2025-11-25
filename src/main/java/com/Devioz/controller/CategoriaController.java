package com.Devioz.controller;

import com.Devioz.model.Categoria;
import com.Devioz.service.CategoriaService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Listar todas las categorías
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    // Buscar categoría por ID
    @GetMapping("/{id}")
    public Optional<Categoria> getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }

    // Buscar categoría por nombre
    @GetMapping("/name/{name}")
    public Optional<Categoria> getCategoriaByName(@PathVariable String name) {
        return categoriaService.getCategoriaByName(name);
    }

    // Crear nueva categoría
    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    // Actualizar categoría existente
    @PutMapping("/{id}")
    public Categoria updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        return categoriaService.saveCategoria(categoria);
    }

    // Eliminar categoría
    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }

}
