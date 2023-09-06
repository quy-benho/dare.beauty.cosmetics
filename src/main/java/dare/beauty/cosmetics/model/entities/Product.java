package dare.beauty.cosmetics.model.entities;

import dare.beauty.cosmetics.util.DbParam;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity(name = DbParam.TBL_PRODUCT)
@Data
public class Product extends GeniricEntity {
    @Column(name = DbParam.NAME)
    private String name;
    @Column(name = DbParam.S_DESC)
    private String desc;
    @Column(name = DbParam.CATALOG_ID)
    private String catalogId;
    @Column(name = DbParam.IMG_URL)
    private String imageUrl;
    @Column(name = DbParam.BASE_COST)
    private String baseCost;
}
