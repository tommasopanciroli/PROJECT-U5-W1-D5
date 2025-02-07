package com.example.project.project_u5_w1_d5.edifici;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioRepo extends JpaRepository<Edificio, Long> {

    boolean existsByNome(String nome);

    List<Edificio> findByCity(String city);
}