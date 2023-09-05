package dare.beauty.cosmetics.data.repository;

import dare.beauty.cosmetics.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsernameAndPassword(String userName, String passwrod);
}
