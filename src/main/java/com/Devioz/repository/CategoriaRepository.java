package com.Devioz.repository;
import com.Devioz.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    //Buscar categoría por nombre (opcional)
    Categoria findByName(String name);

    //Verificar si existe una categoría por nombre
    boolean existsByName(String name);
}
