package dare.beauty.cosmetics.data.repository;

import dare.beauty.cosmetics.model.entities.Account;
import dare.beauty.cosmetics.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByUserNameAndPassword(String userName, String passwrod);
}
