package fr.kolie.ispe.catchup.repository;

import fr.kolie.ispe.catchup.beans.Catchup;
import fr.kolie.ispe.catchup.beans.Inscripton;
import fr.kolie.ispe.catchup.beans.KeyComposite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscripton, KeyComposite> {

    //
    // List<Inscripton> findByRattrapage(Catchup catchup);
}
