package fr.kolie.ispe.catchup.beans;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "matiere")
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matiere")
    private int id_matiere;

    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

}
