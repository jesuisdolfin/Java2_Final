package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dmacc.beans.;

@Repository
public interface SportsRepository extends JpaRepository<Contact, Long> {

}


