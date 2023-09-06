package dare.beauty.cosmetics.model.entities;

import dare.beauty.cosmetics.util.DbParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
@MappedSuperclass
public class GeniricEntity implements Serializable {
    @Id
    @Column(name = DbParam.ID)
    protected String id;
    @Column(name = DbParam.STATE)
    protected String state;
    @Column(name = DbParam.CREATE_DATE)
    protected Date createDate;
    @Column(name = DbParam.UPDATE_DATE)
    protected Date updateDate;
    @Column(name = DbParam.ACTIVE)
    protected boolean active;
}
