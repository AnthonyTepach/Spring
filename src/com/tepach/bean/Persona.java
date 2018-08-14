/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tepach.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Anthony Tepach
 */
public class Persona implements InitializingBean, DisposableBean{
    
    private int id;
    
   
    private String nombre;
    
 
    private String apodo;
    
    @Autowired
    private Pais pais;

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
  

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean iniciando: "+ this.getClass().getName()); 
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean destruido: "+ this.getClass().getName());
    }
}
