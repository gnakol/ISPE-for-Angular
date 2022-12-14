package fr.kolie.ispe.catchup.repository;


import fr.kolie.ispe.catchup.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
