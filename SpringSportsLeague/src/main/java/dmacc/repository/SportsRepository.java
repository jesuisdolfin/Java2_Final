package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dmacc.beans.Player;
import dmacc.beans.Team;

@Repository
public interface SportsRepository extends JpaRepository<Team, Long> {

}


