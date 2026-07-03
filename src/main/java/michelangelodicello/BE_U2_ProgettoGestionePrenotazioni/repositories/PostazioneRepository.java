package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.repositories;

import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.Postazione;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, String> {
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
}
