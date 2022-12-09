package fr.kolie.ispe.catchup.repository;

import fr.kolie.ispe.catchup.beans.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Integer> {
}
