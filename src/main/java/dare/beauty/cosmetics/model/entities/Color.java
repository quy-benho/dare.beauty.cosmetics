package dare.beauty.cosmetics.model.entities;

import dare.beauty.cosmetics.util.DbParam;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = DbParam.COLOR)
public class Color {
    @Id
    @Column(name = DbParam.ID)
    private String id;
    @Column(name = DbParam.NAME)
    private String name;
    @Column(name = DbParam.S_DESC)
    private String desc;
    @Column(name = DbParam.CREATE_DATE)
    private Date createDate;
    @Column(name = DbParam.UPDATE_DATE)
    private Date updateDate;
    @Column(name = DbParam.ACTIVE)
    private boolean active;
}
