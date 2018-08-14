/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tepach.services;

import com.tepach.bean.Persona;

/**
 *
 * @author Anthony Tepach
 */
public interface ServicePersona {
    public void registrar(Persona persona) throws Exception;
    public void actulizar(Persona persona) throws Exception;
    public void elimiar(Persona persona) throws Exception;
}
