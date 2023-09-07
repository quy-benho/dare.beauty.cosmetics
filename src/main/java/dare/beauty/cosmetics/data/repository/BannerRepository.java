package dare.beauty.cosmetics.data.repository;

import dare.beauty.cosmetics.model.entities.Banner;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends PagingAndSortingRepository<Banner, String> {
}