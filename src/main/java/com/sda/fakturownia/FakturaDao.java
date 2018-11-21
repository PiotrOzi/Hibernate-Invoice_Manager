package com.sda.fakturownia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class FakturaDao {

    public boolean saveInvoiceIntoDatabase(Faktura faktura) {

        // pobieramy session factory (fabryka połączeń z bazą)
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            //otwieramy transakcje
            transaction = session.beginTransaction();

            session.save(faktura);
            //zamykamy transakcje i zatwierdzam zmiany
            transaction.commit();

        } catch (SecurityException se) {
            // w razie błędu przywróć stan sprzed transakcji
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
        return true;
    }


    public List<Faktura> getAllInvoicesFromDatabase() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


        try (Session session = sessionFactory.openSession()) {

            //stwórz zapytanie
            Query<Faktura> query = session.createQuery(" from Faktura faktura ", Faktura.class);

            //wywołaj zapytanie
            List<Faktura> faktury = query.list();

            //zwróć wynik
            return faktury;
        } catch (SecurityException se) {
            //jesli cos pojdzie nie tak - wypiszmy komunikat loggerem

            System.err.println(se);
        }
        //jeśli nie uda sie znalezc - zwracamy pusta liste.
        return new ArrayList<>();
    }



}
