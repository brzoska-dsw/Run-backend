package pl.brzoska.runbackend.prodplan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdplanRepository extends JpaRepository<Prodplan, Long> {
}
