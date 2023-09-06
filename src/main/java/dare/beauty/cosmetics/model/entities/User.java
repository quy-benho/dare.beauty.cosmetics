package dare.beauty.cosmetics.model.entities;

import dare.beauty.cosmetics.util.DbParam;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name = DbParam.TBL_USER)
@Data
public class User extends GeniricEntity{
    @Column(name = DbParam.FULLNAME)
    private String name;
    @Column(name = DbParam.AVATAR)
    private String avatar;
    @Column(name = DbParam.ADDRESS)
    private String address;
    @Column(name = DbParam.CITY)
    private String city;
    @Column(name = DbParam.COUNTRY_CODE)
    private String countryCode;
    @Column(name = DbParam.COUNTRY_STATE)
    private String countryState;
    @Column(name = DbParam.ROLE)
    private String role;
    @Column(name = DbParam.GENDER)
    private boolean gender;
    @Column(name = DbParam.BIRTHDAY)
    private Date birthday;
}
