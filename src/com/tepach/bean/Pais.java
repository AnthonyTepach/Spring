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
public class Pais implements InitializingBean, DisposableBean{
    @Value("México")
    private String nombre;
    @Autowired
    private Ciudad ciudad;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
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
