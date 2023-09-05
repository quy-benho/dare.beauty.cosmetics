package dare.beauty.cosmetics.model.entities;

import dare.beauty.cosmetics.util.DbParam;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = DbParam.TBL_USER)
@Data
public class User {
    @Id
    @Column(name = DbParam.ID)
    private String id;
    @Column(name = DbParam.FULLNAME)
    private String name;
    @Column(name = DbParam.AVATAR)
    private String avatar;
    @Column(name = DbParam.USERNAME)
    private String username;
    @Column(name = DbParam.PASSWORD)
    private String password;
    @Column(name = DbParam.ADDRESS)
    private String address;
    @Column(name = DbParam.GENDER)
    private boolean gender;
    @Column(name = DbParam.BIRTHDAY)
    private Date birthday;
    @Column(name = DbParam.STATE)
    private String state;
}
