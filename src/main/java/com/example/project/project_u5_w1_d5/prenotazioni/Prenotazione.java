package com.example.project.project_u5_w1_d5.prenotazioni;

import com.example.project.project_u5_w1_d5.postazioni.Postazione;
import com.example.project.project_u5_w1_d5.utenti.Utente;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazione")
@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "id_postazione")
    private Postazione postazione;
    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;


    public Prenotazione(LocalDate data, Postazione postazione, Utente utente) {
        this.data = data;
        this.postazione = postazione;
        this.utente = utente;
    }
}
