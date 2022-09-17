package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manytoone.Persona;
import com.springsimplespasos.hibernate.entidades.manytoone.Telefono;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;

public class MainManyToOne {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();

        Persona ramon = new Persona(1, "Ramón");
        Persona maria = new Persona(2, "Maria");

        Telefono celularRamon = new Telefono(null, "12345690");
        Telefono fijoRamon = new Telefono(null, "12352345");

        celularRamon.setPersona(ramon);
        fijoRamon.setPersona(ramon);

        ramon.setTelefonos(Arrays.asList(celularRamon, fijoRamon));

        Telefono celularMaria = new Telefono(null, "00123578");
        Telefono fijoMaria = new Telefono(null, "00001345");

        celularMaria.setPersona(maria);
        fijoMaria.setPersona(maria);

        maria.setTelefonos(Arrays.asList(celularMaria,fijoMaria));

        session.beginTransaction();

        session.saveOrUpdate(ramon);
        session.saveOrUpdate(maria);

        session.getTransaction().commit();

        session.close();
    }
}
