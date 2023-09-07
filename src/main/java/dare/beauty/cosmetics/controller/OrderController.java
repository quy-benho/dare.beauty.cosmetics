package dare.beauty.cosmetics.controller;

import dare.beauty.cosmetics.model.response.ResponseData;
import dare.beauty.cosmetics.service.OrderCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderCardService orderCardService;

    @GetMapping("/card")
    public ResponseData<Objects> getCardByUserId(
    ){
         orderCardService.getCardByUserId();
        return ResponseData.ok();
    }
}
