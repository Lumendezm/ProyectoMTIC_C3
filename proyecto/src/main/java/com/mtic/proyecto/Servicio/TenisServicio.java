package com.mtic.proyecto.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtic.proyecto.Modelo.Tenis;
import com.mtic.proyecto.Repositorio.TenisRepositorio;

@Service
public class TenisServicio {

    /**
     * LLamado al repositorio con los metodos CRUD para tenis
     */
    @Autowired
    private TenisRepositorio tenisRepo;

    
    /** 
     * @return List<Tenis> Lista de tenis almacenada en la base de datos
     */
    public List<Tenis> listarTodos(){
        return tenisRepo.findAll();
    }

    
    /** 
     * @param tenis Objeto tenis a ser guardado en la base de datos
     */
    public void guardarTenis(Tenis tenis){
        tenisRepo.save(tenis);
    }
    
    
    /** 
     * @param id Identificador del tenis a ser eliminado
     */
    public void eliminar(Long id){
        tenisRepo.deleteById(id);
    }

    
    /** 
     * @param id Identificador del tenis a ser buscado
     * @return Tenis Objeto Tenis con el identificador pasado como parametro
     */
    public Tenis seleccionar(Long id){
        return tenisRepo.findById(id).get();
    }

    
    /** 
     * @param keyword Palabra clave utilizada para buscar por esa caracteristica
     * @return List<Tenis> Lista de tenis que concuerden con la palabra clave
     */
    public List<Tenis> getByKeyword(String keyword){
        return tenisRepo.findByKeyword(keyword);
    }
}
