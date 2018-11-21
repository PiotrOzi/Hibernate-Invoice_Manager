package com.sda.fakturownia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static{
        //Tworzymy sobie obiekt ktory pobiera konfiguracje z pliku hibernate cfg xml
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        //metadata to informacje dotyczące plików z danych załadowanych wczesniej
        //tworzymy sobie obiekt metadata
        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        //stworzenie sesji z danych zawartych w pliku hibernate cfg xml
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
