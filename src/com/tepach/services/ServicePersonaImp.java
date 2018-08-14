/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tepach.services;

import com.tepach.bean.Persona;
import com.tepach.interfaces.DAOPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

@Service
public class ServicePersonaImp implements ServicePersona {

    @Autowired
    private DAOPersona dAOPersona;

    @Override
    public void registrar(Persona persona) throws Exception {
        try {
            dAOPersona.registrar(persona);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void actulizar(Persona persona) throws Exception {
        try {
            dAOPersona.actualizar(persona);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void elimiar(Persona persona) throws Exception {
        try {
            dAOPersona.eliminar(persona);
        } catch (Exception e) {
            throw e;
        }
    }

}
