package com.example.project.project_u5_w1_d5.config;

import com.example.project.project_u5_w1_d5.edifici.Edificio;
import com.example.project.project_u5_w1_d5.utenti.Utente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.github.javafaker.Faker;
import java.util.Locale;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    Faker faker= new Faker(Locale.ITALY);

    @Bean
    public Edificio edificio1(){
        return new Edificio("Con Mollica o Senza", "Via Napoli 4", "Napoli");
    }

    @Bean
    public Edificio edificio2(){
        return new Edificio("Castello Sforzesco", "Piazza del duomo 3", "Milano");
    }
    @Bean
    public Edificio edificio3(){
        return  new Edificio("Bosco Verticale", "Via del Bosco Verticale", "Milano");
    }
    @Bean
    public Edificio edificio4(){
        return new Edificio("Colosseo di Roma", "Via Roma 1", "Roma");
    }
    @Bean
    public Edificio edificio5(){
        return new Edificio("Eliseo", "Champ Elysèe", "Parigi");
    }

    @Bean
    Utente utente(){
        return new Utente(faker.pokemon().name(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
    }
}
