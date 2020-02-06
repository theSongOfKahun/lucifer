package cn.kahun.sa.framework.spring.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Simple {

    private List<Boolean> booleanList = new ArrayList<>(8);
}
