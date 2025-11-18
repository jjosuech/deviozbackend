package com.Devioz.repository;
import com.Devioz.model.Categoria;
import com.Devioz.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

    //Buscar por SKU (código único del producto)
    Optional<Producto> findBySku(String sku);

    //Buscar todos los productos de una categoría
    List<Producto> findByCategoria(Categoria categoria);

    //Buscar productos con stock menor a cierto valor
    List<Producto> findByStockLessThan(Integer stock);

    //Buscar productos por parte del título
    List<Producto> findByTitleContainingIgnoreCase(String title);
}
