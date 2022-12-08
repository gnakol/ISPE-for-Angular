package fr.kolie.ispe.catchup.beans;

import jakarta.persistence.*;
import lombok.Data;

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
}
