package com.sda.fakturownia;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Firma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    String nazwa;
    String nip;
    String adres;


    @OneToMany(mappedBy = "firma", fetch = FetchType.EAGER)
    private List<Faktura> faktury;





}
