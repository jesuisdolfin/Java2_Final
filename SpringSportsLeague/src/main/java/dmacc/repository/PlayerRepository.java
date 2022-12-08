package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dmacc.beans.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}