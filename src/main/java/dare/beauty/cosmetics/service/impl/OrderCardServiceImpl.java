package dare.beauty.cosmetics.service.impl;

import dare.beauty.cosmetics.data.repository.AccountRepository;
import dare.beauty.cosmetics.data.repository.OrderCardRepository;
import dare.beauty.cosmetics.model.entities.OrderCard;
import dare.beauty.cosmetics.model.entities.User;
import dare.beauty.cosmetics.model.request.LoginRequest;
import dare.beauty.cosmetics.model.response.LoginResponse;
import dare.beauty.cosmetics.service.OrderCardService;
import dare.beauty.cosmetics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCardServiceImpl implements OrderCardService {

    @Autowired
    OrderCardRepository orderCardRepository;


    @Override
    public List<OrderCard> getCardByUserId() {
        String userId= "";
        String state= "";
        return orderCardRepository.findAllByUserIdAndState(userId, state);
    }
}
