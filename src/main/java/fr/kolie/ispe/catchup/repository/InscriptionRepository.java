package fr.kolie.ispe.catchup.repository;

import fr.kolie.ispe.catchup.beans.Catchup;
import fr.kolie.ispe.catchup.beans.Inscription;
import fr.kolie.ispe.catchup.beans.KeyComposite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, KeyComposite> {

    List<Inscription> findByCatchup(Catchup catchup);
}
