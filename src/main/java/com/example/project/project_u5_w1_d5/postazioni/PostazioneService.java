package com.example.project.project_u5_w1_d5.postazioni;

import com.example.project.project_u5_w1_d5.exceptions.ItemNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostazioneService {

    @Autowired
    private PostazioneRepo postazioneRepository;


    public void savePostazione(Postazione newPostazione){

        if(postazioneRepository.existsByDescrizione(newPostazione.getDescrizione())) {
            throw new RuntimeException("La postazione " + newPostazione.getDescrizione() + " è già presente nel db!");
        }

        postazioneRepository.save(newPostazione);
        System.out.println(newPostazione.getDescrizione() + " Salvato correttamente nel db");
    }

    public Postazione findById(long postazioneId){

        return postazioneRepository.findById(postazioneId).orElseThrow(() -> new ItemNotFound(postazioneId));

    }

    public List<Postazione> findByTipo(String tipo){
        return postazioneRepository.findByTipo(tipo);
    }

    public List<Postazione> findByTipoAndCity(String tipo, String city){
        return postazioneRepository.findByTipoAndCity(tipo, city);
    }

}
