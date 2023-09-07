package dare.beauty.cosmetics.controller;

import dare.beauty.cosmetics.model.response.ResponseData;
import dare.beauty.cosmetics.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @GetMapping("/{id}")
    public ResponseData<Objects> getBannerById(
            @PathVariable(name = "id") String id
    ){
        bannerService.getBannerById(id);
        return ResponseData.ok();
    }
}
