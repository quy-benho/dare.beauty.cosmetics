package dare.beauty.cosmetics.model.entities;

import dare.beauty.cosmetics.util.DbParam;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = DbParam.TBL_SIZE)
@Data
public class Size extends GeniricEntity {
    @Column(name = DbParam.NAME)
    private String name;
    @Column(name = DbParam.S_DESC)
    private String desc;
}
