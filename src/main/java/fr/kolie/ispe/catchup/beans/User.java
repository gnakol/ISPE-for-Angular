package fr.kolie.ispe.catchup.beans;

import jakarta.persistence.*;
import lombok.Data;

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
}
