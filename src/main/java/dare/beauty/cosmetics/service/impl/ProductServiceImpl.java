package dare.beauty.cosmetics.service.impl;

import dare.beauty.cosmetics.data.repository.ProductRepository;
import dare.beauty.cosmetics.model.entities.Product;
import dare.beauty.cosmetics.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllpProduct() {
        return productRepository.findAll();
    }
}
