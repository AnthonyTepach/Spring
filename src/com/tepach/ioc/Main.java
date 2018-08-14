package com.tepach.ioc;

import com.tepach.bean.*;
import com.tepach.config.Beans;
import com.tepach.services.ServicePersona;
import java.util.Random;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
       new Main().deleteBD();
    }

    public void porAnotaciones() {
        AnnotationConfigApplicationContext contexto = getcontexto();
        Persona person = (Persona) contexto.getBean("persona");
        Pais country = (Pais) contexto.getBean("pais");
        System.out.println(person.getId() + " " + person.getNombre() + " " + person.getApodo() + " " + person.getPais().getNombre() + " " + country.getCiudad().getNombre());
        closeContexto(contexto);
    }

    private void closeContexto(AnnotationConfigApplicationContext context) {
        ((ConfigurableApplicationContext) context).close();
    }

    public void insertDB() {
        AnnotationConfigApplicationContext contexto = getcontexto();
        Persona per = (Persona) contexto.getBean("persona");
        per.setId(new Random().nextInt(999));
        per.setNombre("Mariana");
        per.setApodo("De Tepach");
        per.getPais().getCiudad().setNombre("CDMX");
        ServicePersona sm = (ServicePersona) contexto.getBean("servicePersonaImp");
        try {
            sm.registrar(per);
        } catch (Exception e) {
            System.out.println("ERROR:\n" + e);

        }
        closeContexto(contexto);
    }

    public void updateDB() {
        AnnotationConfigApplicationContext contexto = getcontexto();
        Persona per = (Persona) contexto.getBean("persona");
        per.setId(20);
        per.setNombre("Anthony");
        per.setApodo("Tepach Reyes");
        per.getPais().getCiudad().setNombre("Metepec");
        ServicePersona sm = (ServicePersona) contexto.getBean("servicePersonaImp");
        try {
            sm.actulizar(per);
        } catch (Exception e) {
            System.out.println("ERROR:\n" + e);

        }
        closeContexto(contexto);

    }

    public void deleteBD() {
        AnnotationConfigApplicationContext contexto = getcontexto();
        Persona per = (Persona) contexto.getBean("persona");
        per.setId(1);
        ServicePersona sm = (ServicePersona) contexto.getBean("servicePersonaImp");
        try {
            sm.elimiar(per);
        } catch (Exception e) {
            System.out.println("ERROR:\n" + e);

        }
        closeContexto(contexto);
    }

    private AnnotationConfigApplicationContext getcontexto() {
        AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext();
        contexto.register(Beans.class);
        contexto.refresh();
        return contexto;
    }

}
