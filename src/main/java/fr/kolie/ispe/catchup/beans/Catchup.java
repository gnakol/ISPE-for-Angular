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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_professeur")
    @JsonIgnoreProperties({"catchupSurveillant", "catchupProfesseur"})
    private User professeur;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_surveillant")
    @JsonIgnoreProperties({"catchupSurveillant", "catchupProfesseur"})
    private User surveillant;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_salle")
    @JsonIgnoreProperties({"catchup"})
    private Salle salle;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_matiere")
    @JsonIgnoreProperties({"catchUp"})
    private Matiere matiere;

}
