package com.example.project.project_u5_w1_d5.utenti;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepo extends JpaRepository<Utente, Long> {

    boolean existsByUsername(String username);
    boolean existsByNomeAndCognome(String nome, String cognome);
    boolean existsByEmail(String email);

}
