package com.example.project.project_u5_w1_d5.prenotazioni;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepo prenotazioneRepository;

    public void savePrenotazione(Prenotazione newPrenotazione) {

        if (prenotazioneRepository.existsByUtenteAndData(newPrenotazione.getUtente(), newPrenotazione.getData())) {
            throw new RuntimeException("L'utente " + newPrenotazione.getUtente().getNome() + " Ha già una prenotazione in questa data");
        }
        if (prenotazioneRepository.findByPostazioneAndData(newPrenotazione.getPostazione(), newPrenotazione.getData()).size() >= newPrenotazione.getPostazione().getNumeroMaxPartecipanti()) {
            throw new RuntimeException("Capienza massima raggiunta per la postazione " + newPrenotazione.getPostazione().getId());
        }
        prenotazioneRepository.save(newPrenotazione);
        System.out.println("Prenotazione " + newPrenotazione.getId() + " salvata con successo");
    }

}