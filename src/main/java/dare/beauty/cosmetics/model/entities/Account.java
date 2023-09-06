package dare.beauty.cosmetics.model.entities;

import dare.beauty.cosmetics.util.DbParam;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = DbParam.ACCOUNT)
@Data
public class Account extends GeniricEntity {
    @Column(name = DbParam.USER_ID)
    private String userId;
    @Column(name = DbParam.USERNAME)
    private String userName;
    @Column(name = DbParam.PASSWORD)
    private String password;
}
