package dare.beauty.cosmetics.controller;


import dare.beauty.cosmetics.model.entities.Color;
import dare.beauty.cosmetics.model.response.ResponseData;
import dare.beauty.cosmetics.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/option")
public class OptionController {

    @Autowired
    OptionService optionService;

    @GetMapping("/color/list")
    public ResponseData<List<Color> > login(
    ){
        List<Color> result = optionService.getAllColor();
        return ResponseData.ok(result);
    }
}
