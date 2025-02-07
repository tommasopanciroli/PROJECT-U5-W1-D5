package com.example.project.project_u5_w1_d5.runners;

import com.example.project.project_u5_w1_d5.ProjectU5W1D5Application;
import com.example.project.project_u5_w1_d5.edifici.Edificio;
import com.example.project.project_u5_w1_d5.edifici.EdificioService;
import com.example.project.project_u5_w1_d5.enums.Tipo;
import com.example.project.project_u5_w1_d5.postazioni.Postazione;
import com.example.project.project_u5_w1_d5.postazioni.PostazioneService;
import com.example.project.project_u5_w1_d5.prenotazioni.Prenotazione;
import com.example.project.project_u5_w1_d5.prenotazioni.PrenotazioneService;
import com.example.project.project_u5_w1_d5.utenti.Utente;
import com.example.project.project_u5_w1_d5.utenti.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GestionePrenotazioni implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;


    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectU5W1D5Application.class);


        Edificio edificio2 = (Edificio) context.getBean("edificio2");

        Edificio edificio3 = (Edificio) context.getBean("edificio3");

        Edificio edificio4 = (Edificio) context.getBean("edificio4");

        Edificio edificio5 = (Edificio) context.getBean("edificio5");

        Edificio edificio1 = edificioService.findById(106);


        Postazione postazione1 = new Postazione("Openspace curato con postazioni singole per lavorare in pace", Tipo.OPENSPACE, 9, edificio1);


        Utente utente1 = context.getBean(Utente.class);

        Utente utente = utenteService.findById(452);

        Postazione postazione = postazioneService.findById(402);

        Prenotazione prenotazione1 = new Prenotazione(LocalDate.now().plusWeeks(2), postazione, utente);


        postazioneService.findByTipo("PRIVATO").forEach(System.out::println);
        postazioneService.findByTipoAndCity("PRIVATO", "Roma").forEach(System.out::println);
        edificioService.findByCity("Roma").forEach(System.out::println);


        context.close();
    }
}