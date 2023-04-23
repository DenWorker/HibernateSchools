package org.ddd;

import Models.Principal;
import Models.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    static Configuration configuration = new Configuration()
            .addAnnotatedClass(Principal.class)
            .addAnnotatedClass(School.class);

    static SessionFactory sessionFactory = configuration.buildSessionFactory();
    static Session session = sessionFactory.getCurrentSession();

    public static void main(String[] args) {
        try {
            session.beginTransaction();

            getPrincipalAndHisSchool(6);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    public static void getPrincipalAndHisSchool(int idOfPrincipal) {
        Principal principal = session.get(Principal.class, idOfPrincipal);
        System.out.println("Информация о директоре:");
        System.out.println(principal.toString());
        System.out.println("Информация о его школе директоре:");
        System.out.println(principal.getSchool().toString());
        System.out.println("-------------------------------------");
    }
}

