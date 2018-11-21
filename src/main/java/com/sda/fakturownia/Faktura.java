package com.sda.fakturownia;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faktura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nazwa;
    private LocalDate data_wystawienia;
    private LocalDate termin_platnosci;
    private String kwota;
    private String nip_firmy_wystawiajacej;
    private String nip_platnika;



    @ManyToOne(fetch = FetchType.LAZY)
    private Firma firma;

}
