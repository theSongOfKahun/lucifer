package cn.kahun.sa.framework.spring.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceOfBirth {

    private String city;
    private String country;

    public PlaceOfBirth(String city) {
        this.city=city;
    }

    public PlaceOfBirth(String city, String country) {
        this(city);
        this.country = country;
    }
}