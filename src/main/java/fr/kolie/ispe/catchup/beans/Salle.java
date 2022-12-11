package fr.kolie.ispe.catchup.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "salle")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salle")
    private int id_salle;

    @Column(name = "nom")
    private String nom;

    @Column(name = "nbr_place")
    private int nombre_place;

    @OneToMany(mappedBy = "salle" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"salle", "matiere", "professeur", "surveillant"})
    private List<Catchup> liste_catchups_salle;
}
