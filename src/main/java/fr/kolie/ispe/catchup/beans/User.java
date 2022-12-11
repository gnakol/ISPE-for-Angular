package fr.kolie.ispe.catchup.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "personne")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personne")
    private int id_user;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    // Ici on la liste des rattrapage par professeur selon son Id
    // Après on ignore les repetition des autre objets sur cette liste
    // En gros sur une propriete liste le @JsonIgnore faut juste ignorer les simple oject sans liste

    @OneToMany(mappedBy = "professeur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"matiere", "salle", "professeur", "surveillant"})
    private List<Catchup> liste_catchups_professeur;

    @OneToMany(mappedBy = "surveillant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"matiere", "salle", "professeur", "surveillant"})
    private List<Catchup> liste_catchups_surveillant;
}
