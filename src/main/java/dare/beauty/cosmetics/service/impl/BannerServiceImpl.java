package dare.beauty.cosmetics.service.impl;

import dare.beauty.cosmetics.data.repository.BannerRepository;
import dare.beauty.cosmetics.model.entities.Banner;
import dare.beauty.cosmetics.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BannerServiceImpl  implements BannerService {

    @Autowired
    BannerRepository bannerRepository;

    @Override
    public void getBannerById(String id) {
        Optional<Banner> oplBanner = bannerRepository.findById(id);
    }
}
