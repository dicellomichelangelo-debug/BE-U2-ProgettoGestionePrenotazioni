package michelangelodicello.BE_U2_ProgettoGestionePrenotazioni.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "edificio")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Edificio {

    @Id
    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "indirizzo", nullable = false)
    private String indirizzo;

    @Column(name = "citta", nullable = false)
    private String citta;

    public Edificio(String nome, String citta, String indirizzo) {
        this.nome = nome;
        this.citta = citta;
        this.indirizzo = indirizzo;
    }
}
