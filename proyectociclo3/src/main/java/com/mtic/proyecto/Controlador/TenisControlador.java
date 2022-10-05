package com.mtic.proyecto.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.mtic.proyecto.Modelo.Tenis;
import com.mtic.proyecto.Servicio.TenisServicio;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TenisControlador {

    @Autowired
    private TenisServicio tenisServicio;

    
    /** 
     * @param modelo Modelo con la informacion del tenis
     * @return String Vista a ser direccionado al recibir y modificar el modelo
     */
    @RequestMapping(value = { "/Ver" }, method = RequestMethod.GET)
    public String paginaVer(Model modelo) {
        List<Tenis> listaTenis = tenisServicio.listarTodos();
        modelo.addAttribute("listaTenis", listaTenis);
        return "Ver";
    }

    
    /** 
     * @param tenis Objeto a ser modificado
     * @param modelo Modelo con la informacion del tenis
     * @param keyword Palabra clave a ser utilizada para la busqueda
     * @return String Vista a ser direccionado al recibir y modificar el modelo
     */
    @RequestMapping(path = { "/Busqueda" })
    public String paginaBusqueda(Tenis tenis, Model modelo, String keyword) {
        if (keyword != null) {
            List<Tenis> listaTenis = tenisServicio.getByKeyword(keyword);
            modelo.addAttribute("listaTenis", listaTenis);
        } else {
            List<Tenis> listaTenis = tenisServicio.listarTodos();
            modelo.addAttribute("listTenis", listaTenis);
        }
        return "Ver";
    }

    
    /** 
     * @return String Vista a ser direccionado cuando se haga el llamado a la ruta "/"
     */
    @RequestMapping(value = { "/" })
    public String paginaBienvenido() {
        return "Bienvenido";
    }
    
    
    /** 
     * @param modelo Modelo con la informacion del tenis
     * @return String Vista a ser direccionado al recibir y modificar el modelo
     */
    @RequestMapping(value = { "/Agregar" })
    public String paginaAgregar(Model modelo) {
        Tenis tenis = new Tenis();
        modelo.addAttribute("tenis", tenis);
        return "Agregar";
    }

    
    /** 
     * @param tenis Objeto a ser modificado
     * @return String Vista a ser direcccionado al recibir y modificar el objeto
     */
    @RequestMapping(value = { "/Guardar" }, method = RequestMethod.POST)
    public String guardarTenis(@ModelAttribute("tenis") Tenis tenis) {
        tenisServicio.guardarTenis(tenis);
        return "redirect:/Ver";
    }

    
    /** 
     * @param id Identificador del tenis sa ser modificado
     * @return ModelAndView Modelo con la informacion insertada del tenis modificado
     */
    @RequestMapping(value = { "/Editar/{id}" })
    public ModelAndView editarTenis(@PathVariable(name = "id") Long id) {
        ModelAndView modelo = new ModelAndView("Editar");
        Tenis tenis = tenisServicio.seleccionar(id);
        modelo.addObject("tenis", tenis);
        return modelo;
    }

    
    /** 
     * @param id Identificador del tenis a ser eliminado
     * @return String Vista a ser direccionado cuando se haya eliminado el tenis
     */
    @RequestMapping(value = { "/Eliminar/{id}" })
    public String eliminarTenis(@PathVariable(name = "id") Long id) {
        tenisServicio.eliminar(id);
        return "redirect:/Ver";
    }

    
    /** 
     * @param id Identificador del tenis a ser modificado
     * @return String Vista a ser direccionado cuando se haya modificado el tenis
     */
    @RequestMapping(value = { "/Remover/{id}" })
    public String removerTenis(@PathVariable(name = "id") Long id) {
        if(tenisServicio.seleccionar(id).getCantidad() <= 0){
            tenisServicio.eliminar(id);
            return "redirect:/Ver";
        }
        Tenis tenisModificado = tenisServicio.seleccionar(id);
        tenisModificado.setCantidad(tenisModificado.getCantidad() - 1);
        tenisServicio.eliminar(id);
        tenisServicio.guardarTenis(tenisModificado);
        return "redirect:/Ver";
    }

    
    /** 
     * @param id Identificador del tenis a ser modificado
     * @return String Vista a ser direccionado cuando se haya modificado el tenis
     */
    @RequestMapping(value = { "/Adicionar/{id}" })
    public String adicionarTenis(@PathVariable(name = "id") Long id) {
        Tenis tenisModificado = tenisServicio.seleccionar(id);
        tenisModificado.setCantidad(tenisModificado.getCantidad() + 1);
        tenisServicio.eliminar(id);
        tenisServicio.guardarTenis(tenisModificado);
        return "redirect:/Ver";
    }

}
