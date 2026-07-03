package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.repositories;

import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, String> {
}
