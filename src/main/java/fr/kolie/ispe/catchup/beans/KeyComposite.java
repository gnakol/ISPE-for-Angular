package fr.kolie.ispe.catchup.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;

import java.io.Serializable;

@Embeddable
@Builder(toBuilder = true)
public class KeyComposite implements Serializable {

    @Column(name = "id_eleve")
    private int key_etudiant;

    @Column(name = "id_rattrapage")
    private int key_catchup;

    public KeyComposite() {
    }

    public KeyComposite(int key_catchup, int key_inscription) {
        this.key_etudiant = key_catchup;
        this.key_catchup = key_inscription;
    }

    public int getKey_etudiant() {
        return key_etudiant;
    }

    public void setKey_etudiant(int key_etudiant) {
        this.key_etudiant = key_etudiant;
    }

    public int getKey_catchup() {
        return key_catchup;
    }

    public void setKey_catchup(int key_catchup) {
        this.key_catchup = key_catchup;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
