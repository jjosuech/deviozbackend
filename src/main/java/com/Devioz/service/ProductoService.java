package com.Devioz.service;
import com.Devioz.model.Producto;
import com.Devioz.model.Categoria;
import com.Devioz.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    public Optional<Producto> getProductoBySku(String sku) {
        return productoRepository.findBySku(sku);
    }

    public List<Producto> getProductosByCategoria(Categoria categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    public List<Producto> getProductosConBajoStock(Integer stockMinimo) {
        return productoRepository.findByStockLessThan(stockMinimo);
    }

    public List<Producto> buscarPorTitulo(String titulo) {
        return productoRepository.findByTitleContainingIgnoreCase(titulo);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
