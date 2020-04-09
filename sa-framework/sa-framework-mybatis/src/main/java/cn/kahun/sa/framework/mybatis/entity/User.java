package cn.kahun.sa.framework.mybatis.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String username;

    private String nickname;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Date registerDate;

    private Byte status;

    private Byte type;

    private String unionId;

    private String logo;

    private Date createTime;

    private Date ts;

}