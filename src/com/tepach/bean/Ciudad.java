/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tepach.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Anthony Tepach
 */
public class Ciudad implements InitializingBean, DisposableBean{
    @Value("CDMX")
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
