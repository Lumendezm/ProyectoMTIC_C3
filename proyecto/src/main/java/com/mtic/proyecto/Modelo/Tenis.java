package com.mtic.proyecto.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Modelo del Tenis
 */
@Entity
public class Tenis {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String marca;

    @Column
    private int tamanio;

    @Column
    private int cantidad;

    @Column
    private float precio;

   
    public Tenis() {
    }

    /**
     * Constructor general
     * 
     * @param id Identificador del tenis
     * @param nombre Nombre del tenis
     * @param marca Marca del tenis
     * @param tamanio Tamaño del tenis
     * @param cantidad Cantidad en stock del tenis
     * @param precio Precio del tenis
     * 
     */
    public Tenis(Long id, String nombre, String marca, int tamanio, int cantidad, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.tamanio = tamanio;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    
    /** 
     * Metodo getter
     * @return El identificador del tenis
     */
    public Long getId() {
        return this.id;
    }

    
    /** 
     * Metodo setter
     * @param id Identificador del tenis
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /** 
     * Metodo getter
     * @return El nombre del tenis
     */
    public String getNombre() {
        return this.nombre;
    }

    
    /** 
     * Metodo setter
     * @param nombre Nombre del tenis 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /** 
     * Metodo getter
     * @return La marca del tenis
     */
    public String getMarca() {
        return this.marca;
    }

    
    /** 
     * Metodo setter
     * @param marca Marca del tenis
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    /** 
     * Metodo getter
     * @return El tamaño del tenis
     */
    public int getTamanio() {
        return this.tamanio;
    }

    
    /** 
     * Metodo setter
     * @param tamanio Tamaño del tenis
     */
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    
    /** 
     * Metodo getter
     * @return La cantidad de tenis en stock
     */
    public int getCantidad() {
        return this.cantidad;
    }

    
    /** 
     * Metodo setter
     * @param cantidad Cantidad en stock del tenis
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    /** 
     * Metodo getter
     * @return El precio del tenis
     */
    public float getPrecio() {
        return this.precio;
    }

    
    /** 
     * Metodo setter
     * @param precio Precio unitario del tenis
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
    /** 
     * Metodo setter para id individual
     * @param id Identificador del tenis
     * @return Tenis Tenis con el identificador pasado como parametro
     */
    public Tenis id(Long id) {
        setId(id);
        return this;
    }

    
    /** 
     * Metodo setter para nombre individual
     * @param nombre Nombre del tenis
     * @return Tenis Tenis con el nombre pasado como parametro
     */
    public Tenis nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    
    /** 
     * Metodo setter para marca individual
     * @param marca Marca del tenis
     * @return Tenis Tenis con la marca pasada como parametro
     */
    public Tenis marca(String marca) {
        setMarca(marca);
        return this;
    }

    
    /** 
     * Metodo setter para tamanio individual
     * @param tamanio Tamaño del tenis
     * @return Tenis Tenis con el tamaño pasado como parametro
     */
    public Tenis tamanio(int tamanio) {
        setTamanio(tamanio);
        return this;
    }

    
    /** 
     * Metodo setter para cantidad individual
     * @param cantidad Cantidad en stock del tenis
     * @return Tenis Tenis con el tamaño pasado como parametro
     */
    public Tenis cantidad(int cantidad) {
        setCantidad(cantidad);
        return this;
    }

    
    /** 
     * Metodo setter para precio individual
     * @param precio Precio del tenis
     * @return Tenis Tenis con el precio pasado como parametro
     */
    public Tenis precio(float precio) {
        setPrecio(precio);
        return this;
    }
    
    
    /** 
     * Metodo toString
     * @return String La informacion del tenis en formato secuencial
     */
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", marca='" + getMarca() + "'" +
            ", tamanio='" + getTamanio() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            ", precio='" + getPrecio() + "'" +
            "}";
    }


}
