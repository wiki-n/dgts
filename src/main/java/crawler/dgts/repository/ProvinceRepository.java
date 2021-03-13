package crawler.dgts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import crawler.dgts.entity.Province;

public interface ProvinceRepository extends CrudRepository<Province, Integer>{
	@Query(value="SELECT * FROM PROVINCE WHERE CODE = :code", nativeQuery = true)
	List<Province> getProvinceByCode(@Param("code") int code);
}
