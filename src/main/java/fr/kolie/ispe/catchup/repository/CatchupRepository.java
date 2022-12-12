package fr.kolie.ispe.catchup.repository;

import fr.kolie.ispe.catchup.beans.Catchup;
import fr.kolie.ispe.catchup.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatchupRepository extends JpaRepository<Catchup, Integer> {

    List<Catchup> findByProfesseur(User professeur);

    List<Catchup> findBySurveillant(User surveillant);

    List<Catchup> findByEtat(String etat);

    List<Catchup> findByEtatAndSurveillant(String etat, User surveillant);

    List<Catchup> findByEtatAndProfesseur(String etat, User professeur);

}
