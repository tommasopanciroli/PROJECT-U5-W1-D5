package com.example.project.project_u5_w1_d5.utenti;

import com.example.project.project_u5_w1_d5.exceptions.ItemNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepository;


    public void saveUtente(Utente newUtente) {


        if (utenteRepository.existsByUsername(newUtente.getUsername())) {
            throw new RuntimeException("Lo username ' " + newUtente.getUsername() + " è già presente nel db!");
        }

        if (utenteRepository.existsByNomeAndCognome(newUtente.getNome(), newUtente.getCognome())) {
            throw new RuntimeException("L'utente " + newUtente.getNome() + " " + newUtente.getCognome() + " è già presente nel db!");
        }

        if (utenteRepository.existsByEmail(newUtente.getEmail())) {
            throw new RuntimeException("La mail " + newUtente.getEmail() + " è già presente nel db!");
        }

        utenteRepository.save(newUtente);
        System.out.println("L'utente " + newUtente.getNome() + " è stato salvato nel db");


    }

    public Utente findById(long utenteId) {

        return utenteRepository.findById(utenteId).orElseThrow(() -> new ItemNotFound(utenteId));

    }

}