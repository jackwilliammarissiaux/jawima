package jawima.ecolotest.ecolotest.repository;

import jawima.ecolotest.ecolotest.model.EcoLoTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EcoloTestRepository extends CrudRepository<EcoLoTest,Long> {
}
