package dare.beauty.cosmetics.model.entities;

import dare.beauty.cosmetics.util.DbParam;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity(name = DbParam.TBL_CATALOG)
public class Catalog extends GeniricEntity {

    @Column(name = DbParam.NAME)
    private String name;
    @Column(name = DbParam.S_DESC)
    private String desc;

}
