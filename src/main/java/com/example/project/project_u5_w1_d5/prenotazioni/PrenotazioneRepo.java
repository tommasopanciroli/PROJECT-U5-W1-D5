package com.example.project.project_u5_w1_d5.prenotazioni;

import com.example.project.project_u5_w1_d5.postazioni.Postazione;
import com.example.project.project_u5_w1_d5.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {

    boolean existsByUtenteAndData(Utente utente, LocalDate data);

    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);

}