package cn.kahun.sa.framework.spring.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Inventor {

    private String name;
    private Date birthday;
    private String nationality;

}
