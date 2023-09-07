package dare.beauty.cosmetics.model.entities;

import dare.beauty.cosmetics.util.DbParam;
import lombok.Data;

import javax.persistence.Entity;
@Data
@Entity(name = DbParam.TBL_BANNER)
public class Banner extends GeniricEntity{
    private String userId;
}
