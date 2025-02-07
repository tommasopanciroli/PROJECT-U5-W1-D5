package com.example.project.project_u5_w1_d5.postazioni;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostazioneRepo extends JpaRepository<Postazione, Long> {
    boolean existsByDescrizione (String descrizione);

    @Query("SELECT a FROM Postazione a WHERE a.tipo = UPPER(:tipo)")
    List<Postazione> findByTipo(String tipo);

    @Query("SELECT a FROM Postazione a WHERE a.tipo = UPPER(:tipo) AND a.edificio.city = :city")
    List<Postazione> findByTipoAndCity(String tipo, String city);
}
