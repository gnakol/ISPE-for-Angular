package fr.kolie.ispe.catchup.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;

import java.io.Serializable;

@Embeddable
@Builder(toBuilder = true)
public class KeyComposite implements Serializable {

    @Column(name = "id_eleve")
    private int key_catchup;

    @Column(name = "id_rattrapage")
    private int key_inscription;

    public KeyComposite() {
    }

    public KeyComposite(int key_catchup, int key_inscription) {
        this.key_catchup = key_catchup;
        this.key_inscription = key_inscription;
    }

    public int getKey_catchup() {
        return key_catchup;
    }

    public void setKey_catchup(int key_catchup) {
        this.key_catchup = key_catchup;
    }

    public int getKey_inscription() {
        return key_inscription;
    }

    public void setKey_inscription(int key_inscription) {
        this.key_inscription = key_inscription;
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
