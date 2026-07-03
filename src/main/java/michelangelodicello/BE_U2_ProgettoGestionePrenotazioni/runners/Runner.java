package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.runners;

import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.*;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.services.EdificioService;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.services.PostazioneService;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.services.PrenotazioneService;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.services.UtenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {

    private final UtenteService utenteService;
    private final EdificioService edificioService;
    private final PostazioneService postazioneService;
    private final PrenotazioneService prenotazioneService;

    public Runner(UtenteService utenteService, EdificioService edificioService, PostazioneService postazioneService, PrenotazioneService prenotazioneService) {
        this.utenteService = utenteService;
        this.edificioService = edificioService;
        this.postazioneService = postazioneService;
        this.prenotazioneService = prenotazioneService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- GESTIONE PRENOTAZIONI ---");

        Edificio ed = new Edificio("Sede Centrale Roma", "Roma", "Via del Corso 100");
//        edificioService.salvaEdificio(ed);

        Utente utente = new Utente("mario_rossi", "Mario Rossi", "mario.rossi@gmail.com");
//        utenteService.salvaUtente(utente);

        Postazione postazione = new Postazione("ABC123", ed, 4, TipoPostazione.OPENSPACE, "Scrivania OpenSpace Finestra");
//        postazioneService.salvaPostazione(postazione);

        System.out.println("Cerco postazioni OPENSPACE a Roma");
        postazioneService.cercaPostazioni(TipoPostazione.OPENSPACE, "Roma")
                .forEach(p -> System.out.println("Trovata: " + p.getDescrizione()));

        LocalDate domani = LocalDate.now().plusDays(1);
        Utente utenteFromDB = utenteService.trovaPerUsername("mario_rossi");
        Postazione postazioneFromDB = postazioneService.trovaPerCodice("ABC123");

        try {
            Prenotazione pr1 = prenotazioneService.effettuaPrenotazione(utenteFromDB, postazioneFromDB, domani);
            System.out.println("Prenotazione salvata con ID: " + pr1.getIdPrenotazione());

            System.out.println("seconda prenotazione per lo stesso utente nella stessa data");
            prenotazioneService.effettuaPrenotazione(utente, postazione, domani);
        } catch (IllegalStateException e) {
            System.out.println("Il sistema ha bloccato il doppione! Errore: " + e.getMessage());
        }
    }
}
