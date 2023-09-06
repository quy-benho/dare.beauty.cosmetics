package dare.beauty.cosmetics.model.entities;

import dare.beauty.cosmetics.util.DbParam;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = DbParam.TBL_ORDER_CARD)
@Data
public class OrderCard extends GeniricEntity {
    @Column(name = DbParam.PRODUCT_ID)
    private String productId;
    @Column(name = DbParam.QUANTITY)
    private int quantity;
    @Column(name = DbParam.USER_ID)
    private String userId;
    @Column(name = DbParam.PRICE)
    private Double price;
    @Column(name = DbParam.TOTAL)
    private String total;
}
