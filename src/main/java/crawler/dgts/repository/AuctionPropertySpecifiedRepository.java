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
	@Query(value = "update AUCTION_PROPERTY_SPECIFIED_INFO set process_status = 'OK' where AU_PROPERTY_INFO_ID in :auctionPropertyInfoIds", nativeQuery = true)
	void updateProcessStatus(@Param("auctionPropertyInfoIds") List<Integer> auctionPropertyInfoIds);
}
