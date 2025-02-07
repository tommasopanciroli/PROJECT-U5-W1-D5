package com.example.project.project_u5_w1_d5.edifici;

import com.example.project.project_u5_w1_d5.exceptions.ItemNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EdificioService {

    @Autowired
    private EdificioRepo edificioRepository;

    public void saveEdificio(Edificio newEdificio){

        if(edificioRepository.existsByNome(newEdificio.getNome())) {
            throw new RuntimeException("L'edificio " + newEdificio.getNome() + " è già presente nel db!");
        }

        edificioRepository.save(newEdificio);
        System.out.println(newEdificio.getNome() + " Salvato correttamente nel db");
    }

    public Edificio findById(long edificioId){

        return edificioRepository.findById(edificioId).orElseThrow(() -> new ItemNotFound(edificioId));

    }

    public List<Edificio> findByCity(String city){
        return edificioRepository.findByCity(city);
    }
}
