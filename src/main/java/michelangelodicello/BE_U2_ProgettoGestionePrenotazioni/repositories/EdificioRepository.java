package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.repositories;

import michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, String> {
}
