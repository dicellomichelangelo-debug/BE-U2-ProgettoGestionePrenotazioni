package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.repositories;

import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.Postazione;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.Prenotazione;
import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate data);

    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate data);
}
