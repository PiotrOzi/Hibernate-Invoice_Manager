package com.sda.fakturownia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        FakturaDao fakturaDao = new FakturaDao();

        //Firma firma = new Firma();

        boolean czyDziala = true;


        while (czyDziala) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Witaj! Jaka operacje chcesz przeprowadzic? dodaj / listuj / exit \r\n");

            String operacja = scanner.next();
            switch (operacja) {

                case "dodaj":
                    System.out.println("Podaj nazwe:");
                    String nazwa = scanner.next();

                    System.out.println("Podaj date wystawienia faktury (d/MM/yyyy):");
                    String data_wystawienia = scanner.next();
                    LocalDate data_wystawienia_formatted = LocalDate.parse(data_wystawienia, formatter);

                    System.out.println("Podaj termin płatności (d/MM/yyyy) :");
                    String termin_platnosci = scanner.next();
                    LocalDate termin_platnosci_formatted = LocalDate.parse(data_wystawienia, formatter);

                    System.out.println("Podaj kwotę:");
                    String kwota = scanner.next();

                    System.out.println("Podaj nip firmy wystawiającej:");
                    String nip_firmy_wystawiajacej = scanner.next();

                    System.out.println("Podaj nip firmy płacącej:");
                    String nip_firmy_placacej = scanner.next();

                    fakturaDao.saveInvoiceIntoDatabase(new Faktura(null, nazwa, data_wystawienia_formatted, termin_platnosci_formatted, kwota, nip_firmy_wystawiajacej, nip_firmy_placacej, null));
                    System.out.println("\r\n");
                    break;
                case "listuj":
                    System.out.println(fakturaDao.getAllInvoicesFromDatabase());
                    break;
                case "exit":
                    czyDziala = false;
                    HibernateUtil.getSessionFactory().close();
                    break;
                default:
                    System.out.println("Zła komenda, spróbuj ponownie.");
                    czyDziala = true;
                    break;
            }

        }
    }
}


