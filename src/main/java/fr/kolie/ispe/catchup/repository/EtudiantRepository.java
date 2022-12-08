package fr.kolie.ispe.catchup.repository;

import fr.kolie.ispe.catchup.beans.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
}
