package crawler.dgts.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import crawler.dgts.entity.AuctionBriefInfo;

public interface AuctionBriefRepository extends CrudRepository<AuctionBriefInfo, Integer> {
	@Query(value="SELECT COUNT(*) FROM AUCTION_BRIEF_INFO WHERE LINK_LOCATION IS NOT NULL AND  dbms_lob.compare(LINK_LOCATION, :link) = 0", nativeQuery=true)
	Integer countExistedLink(@Param ("link") String link);

}
