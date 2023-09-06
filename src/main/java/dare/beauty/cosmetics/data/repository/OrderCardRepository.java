package dare.beauty.cosmetics.data.repository;

import dare.beauty.cosmetics.model.entities.OrderCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderCardRepository extends JpaRepository<OrderCard, String> {
    List<OrderCard> findAllByUserIdAndState(String userId, String state);
}
