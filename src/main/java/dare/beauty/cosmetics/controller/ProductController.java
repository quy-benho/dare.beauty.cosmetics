package dare.beauty.cosmetics.controller;

import dare.beauty.cosmetics.model.entities.Product;
import dare.beauty.cosmetics.model.response.ResponseData;
import dare.beauty.cosmetics.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public ResponseData<List<Product>> login(
    ){
        List<Product> result = productService.getAllpProduct();
        return ResponseData.ok(result);
    }
}
