package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "postazione")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Postazione {

    @Id
    @Column(name = "codice_univoco", length = 50)
    private String codiceUnivoco;

    @Column(name = "descrizione")
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoPostazione tipo;

    @Column(name = "numero_max_occupanti", nullable = false)
    private Integer numeroMaxOccupanti;

    @ManyToOne
    @JoinColumn(name = "nome_edificio", referencedColumnName = "nome", nullable = false)
    private Edificio edificio;

    public Postazione(String codiceUnivoco, Edificio edificio, Integer numeroMaxOccupanti, TipoPostazione tipo, String descrizione) {
        this.codiceUnivoco = codiceUnivoco;
        this.edificio = edificio;
        this.numeroMaxOccupanti = numeroMaxOccupanti;
        this.tipo = tipo;
        this.descrizione = descrizione;
    }
}
