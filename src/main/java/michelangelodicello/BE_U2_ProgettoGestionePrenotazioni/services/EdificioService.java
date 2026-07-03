package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.services;

import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.Edificio;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.repositories.EdificioRepository;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    private final EdificioRepository edificioRepository;

    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public Edificio salvaEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }
}
