package jawima.ecolotest.ecolotest.repository;

import jawima.ecolotest.ecolotest.model.EcoLoTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface EcoloTestRepository extends CrudRepository<EcoLoTest,Long> {
    // list test Website by Date
    Iterable<EcoLoTest> findEcoLoTestByResultDate(Date date);
    //List test website
    Iterable<EcoLoTest> findEcoLoTestByUrl(String url);

}
