package pl.brzoska.runbackend.rundown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RundownRepository extends JpaRepository<Rundown, Long> {
}
