package fr.kolie.ispe.catchup.repository;

import fr.kolie.ispe.catchup.beans.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Matiere, Integer> {
}
