package crawler.dgts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import crawler.dgts.entity.AuctionPropertyFullInfo;

public interface AuctionPropertyFullInfoRepository  extends CrudRepository<AuctionPropertyFullInfo, Integer>{

	@Query(value = "SELECT * FROM auction_property_full_info_view B WHERE B.PROCESS_STATUS is null FETCH FIRST :max ROWS ONLY", nativeQuery = true)
	List<AuctionPropertyFullInfo> findUnprocessRecords(Integer max);

}