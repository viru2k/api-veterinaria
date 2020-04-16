package com.veterinaria.repository;

import java.util.List;
import java.util.Optional;

import com.veterinaria.dao.articulo.Articulo;


import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticuloRepository extends JpaRepository<Articulo, Long> {
  //  Optional<Articulo> findByNombreyDescripcion(String nombre, String descripcion);
    List<Optional<Articulo>> findByNombreContaining(String nombre);
}