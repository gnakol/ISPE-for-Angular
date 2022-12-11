package fr.kolie.ispe.catchup.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "eleve")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_eleve")
    private int id_etudiant;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "etudiant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"catchup", "etudiant"})
    private List<Inscription> liste_inscriptons_etudiant;
}
