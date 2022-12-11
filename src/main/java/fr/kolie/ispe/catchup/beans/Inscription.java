package fr.kolie.ispe.catchup.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Data
@Entity
@Table(name = "convocation")
public class Inscription {

    @EmbeddedId
    private KeyComposite keyComposite;

    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("id_etudiant")
    @JoinColumn(name="id_eleve", insertable=false, updatable=false)
    @JsonIgnoreProperties({"liste_inscriptons_etudiant"})
    private Etudiant etudiant;

    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("id_catchup")
    @JoinColumn(name="id_rattrapage", insertable=false, updatable=false)
    @JsonIgnoreProperties({"liste_inscriptions_catchup"})
    private Catchup catchup;

    @Column(name = "note")
    private float note;

    @Column(name = "present")
    private boolean present;

    @Column(name = "heure_rendu")
    private Time heureRendu;
}
