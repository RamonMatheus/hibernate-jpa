package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.SimpleEntity;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class HibernateMain {

    public static void main(String[] args) {
        SimpleEntity entity = new SimpleEntity();
        entity.setNombre("Descripcion");
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

}
