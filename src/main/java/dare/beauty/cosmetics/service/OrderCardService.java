package dare.beauty.cosmetics.service;

import dare.beauty.cosmetics.model.entities.OrderCard;

import java.util.List;

public interface OrderCardService {
    List<OrderCard> getCardByUserId();
}
