/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tepach.interfaces;

import com.tepach.bean.Persona;

/**
 *
 * @author Anthony Tepach
 */
public interface DAOPersona {
    public void registrar(Persona persona) throws Exception;
    public void actualizar(Persona persona) throws Exception;
    public void eliminar(Persona persona) throws Exception;
}
