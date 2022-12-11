package fr.kolie.ispe.catchup.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "rattrapage")
public class Catchup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rattrapage")
    private int id_catchup;

    @Column(name = "sujet")
    private String sujet;

    @Column(name = "date")
    private Date date;

    @Column(name = "heure")
    private Time heure;

    @Column(name = "duree")
    private int duree;

    @Column(name = "etat")
    private String etat;

    // Ici on affiche l'object professeur dans totalité vue qu'il reste une proprieté pour catchup
    // Après on ignore les repetition de sa liste sinon sa fera une boucle
    // En gros sur une propriete object le @JsonIgnore faut juste ignorer sa propriete liste
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_professeur")
    @JsonIgnoreProperties({"liste_catchups_surveillant", "liste_catchups_professeur"})
    private User professeur;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_surveillant")
    @JsonIgnoreProperties({"liste_catchups_surveillant", "liste_catchups_professeur"})
    private User surveillant;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_salle")
    @JsonIgnoreProperties({"liste_catchups_salle"})
    private Salle salle;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_matiere")
    @JsonIgnoreProperties({"liste_catchups_matiere"})
    private Matiere matiere;

}
