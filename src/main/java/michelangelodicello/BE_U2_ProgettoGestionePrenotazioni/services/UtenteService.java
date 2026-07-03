package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.services;

import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.Utente;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.exception.NotFoundException;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.repositories.UtenteRepository;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public Utente salvaUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public Utente trovaPerUsername(String username) {
        return utenteRepository.findById(username)
                .orElseThrow(() -> new NotFoundException("Utente non trovato con username: " + username));
    }
}
