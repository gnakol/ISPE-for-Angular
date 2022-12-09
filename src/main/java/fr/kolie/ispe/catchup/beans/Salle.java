package fr.kolie.ispe.catchup.beans;

import jakarta.persistence.*;
import lombok.Data;

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
}
