package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.services;

import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.Postazione;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.Prenotazione;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.Utente;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.repositories.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public Prenotazione effettuaPrenotazione(Utente utente, Postazione postazione, LocalDate data) {

        boolean postazioneOccupata = prenotazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, data);
        if (postazioneOccupata) {
            throw new IllegalStateException("La postazione " + postazione.getCodiceUnivoco() + " è già occupata per il giorno " + data);
        }

        boolean utenteImpegnato = prenotazioneRepository.existsByUtenteAndDataPrenotazione(utente, data);
        if (utenteImpegnato) {
            throw new IllegalStateException("L'utente " + utente.getUsername() + " ha già una prenotazione attiva in data " + data);
        }

        Prenotazione nuovaPrenotazione = new Prenotazione(null, data, postazione, utente);
        
        return prenotazioneRepository.save(nuovaPrenotazione);
    }
}
