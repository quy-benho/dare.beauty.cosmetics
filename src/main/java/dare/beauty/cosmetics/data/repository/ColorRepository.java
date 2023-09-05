package dare.beauty.cosmetics.data.repository;

import dare.beauty.cosmetics.model.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, String> {
}
