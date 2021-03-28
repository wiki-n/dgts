package crawler.dgts.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import crawler.dgts.entity.AuctionBriefInfo;

public interface AuctionBriefRepository extends CrudRepository<AuctionBriefInfo, Integer> {
	@Query(value = "SELECT COUNT(*) FROM AUCTION_BRIEF_INFO WHERE LINK_LOCATION IS NOT NULL AND  dbms_lob.compare(LINK_LOCATION, :link) = 0", nativeQuery = true)
	Integer countExistedLink(@Param("link") String link);

	@Query(value = "select AUTION_INFO_ID from (select ROWNUM as rn, a.* from (select  * from auction_brief_info where process_status is null order by publish_time_1 desc) a ) where rn >= :beginIndex AND rn <= :endIndex", nativeQuery = true)
	List<Integer> getUnprocessAuctionInfoIds(@Param("beginIndex") Integer beginIndex,
			@Param("endIndex") Integer endIndex);

	@Modifying
	@Transactional
	@Query(value = "update auction_brief_info set process_status = 'OK' where AUTION_INFO_ID in :auctionInfoIds", nativeQuery = true)
	void updateProcessStatus(@Param("auctionInfoIds") List<Integer> auctionInfoIds);
}
