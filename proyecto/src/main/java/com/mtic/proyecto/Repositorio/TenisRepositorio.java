package com.mtic.proyecto.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mtic.proyecto.Modelo.Tenis;

/**
 * Interfaz que extiende del repositorio JPA con metodos CRUD
 */
@Repository
public interface TenisRepositorio extends JpaRepository<Tenis, Long> {

    /**
     * 
     * @param keyword Palabra clave con la cual buscar en los elementos
     * @return Lista de tenis que concuerden con la palabra clave (Keyword)
     * 
     */
    @Query(value = "select * from tenis s where s.nombre like %:keyword% or s.marca like %:keyword% or s.tamanio like %:keyword% or s.cantidad like %:keyword%", nativeQuery = true)
    List<Tenis> findByKeyword(@Param("keyword") String keyword);

}
