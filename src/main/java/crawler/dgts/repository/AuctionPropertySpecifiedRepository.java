package crawler.dgts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import crawler.dgts.entity.AuctionPropertySpecifiedInfo;

public interface AuctionPropertySpecifiedRepository extends CrudRepository<AuctionPropertySpecifiedInfo, Integer> {
	@Modifying
	@Transactional
	@Query(value = "update auction_property_specified_info set process_status = :link where AU_PROPERTY_INFO_ID = :auctionPropertyInfoId", nativeQuery = true)
	void updateProcessStatus(@Param("auctionPropertyInfoId") Integer auctionPropertyInfoId, @Param("link") String link);
}
