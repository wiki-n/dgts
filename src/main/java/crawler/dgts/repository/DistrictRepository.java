package crawler.dgts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import crawler.dgts.entity.District;

public interface DistrictRepository extends CrudRepository<District, Integer>{
	@Query(value="SELECT * FROM DISTRICT WHERE CODE = :code", nativeQuery = true)
	List<District> getDistrictByCode(@Param("code") int code);
}
