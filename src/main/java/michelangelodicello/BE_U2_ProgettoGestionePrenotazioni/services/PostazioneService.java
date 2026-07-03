package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.services;

import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.repositories.PostazioneRepository;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {
    private final PostazioneRepository postazioneRepository;

    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }
}
