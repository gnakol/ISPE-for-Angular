package fr.kolie.ispe.catchup.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Data
@Entity
@Table(name = "convocation")
public class Inscripton {

    @EmbeddedId
    private KeyComposite keyComposite;

    @ManyToOne
    @MapsId("id_etudiant")
    @JoinColumn(name="id_eleve", insertable=false, updatable=false)
    private Etudiant etudiant;

    @ManyToOne
    @MapsId("id_catchup")
    @JoinColumn(name="id_catchup", insertable=false, updatable=false)
    @JsonIgnoreProperties({"matiere", "salle", "professeur", "surveillant"})
    private Catchup catchUp;

    private float note;

    private boolean present;

    private Time heureRendu;
}
