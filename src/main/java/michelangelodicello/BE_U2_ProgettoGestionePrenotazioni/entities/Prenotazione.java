package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazione")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"postazione", "utente"})
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrenotazione;

    @ManyToOne
    @JoinColumn(name = "postazione_codice", nullable = false)
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente_username", nullable = false)
    private Utente utente;

    @Column(name = "data_prenotazione", nullable = false)
    private LocalDate dataPrenotazione;

    public Prenotazione(Long idPrenotazione, LocalDate dataPrenotazione, Postazione postazione, Utente utente) {
        this.idPrenotazione = idPrenotazione;
        this.dataPrenotazione = dataPrenotazione;
        this.postazione = postazione;
        this.utente = utente;
    }
}
