package dare.beauty.cosmetics.data.repository;

import dare.beauty.cosmetics.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
