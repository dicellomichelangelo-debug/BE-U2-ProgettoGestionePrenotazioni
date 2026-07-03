package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.services;

import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.Postazione;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.TipoPostazione;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.exception.NotFoundException;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.repositories.PostazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    private final PostazioneRepository postazioneRepository;

    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public Postazione salvaPostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public List<Postazione> cercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }

    public Postazione trovaPerCodice(String codice) {
        return postazioneRepository.findById(codice)
                .orElseThrow(() -> new NotFoundException("Postazione non trovata con codice: " + codice));
    }
}
