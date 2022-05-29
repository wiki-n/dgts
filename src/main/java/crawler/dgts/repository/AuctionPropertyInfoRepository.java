package crawler.dgts.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import crawler.dgts.entity.AuctionPropertyInfo;

public interface AuctionPropertyInfoRepository extends CrudRepository<AuctionPropertyInfo, Integer>{
	@Modifying
	@Transactional
	@Query(value = "update ACTION_PROPERTY_INFO set process_status = 'OK' where AU_PROPERTY_INFO_ID = :auctionPropertyInfoId", nativeQuery = true)
	void updateProcessStatus(@Param("auctionPropertyInfoId") Integer auctionPropertyInfoIds, @Param("link") String link);
}
