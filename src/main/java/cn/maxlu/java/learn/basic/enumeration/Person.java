package cn.maxlu.java.learn.basic.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by max.lu on 2016/1/27.
 */
public enum Person {
    WOMAN("woman"),MAN("man"),UNKNOWN("unknown");

    private Person(String text){
        this.value = text;
    }
    private String value;

    public String getValue() {
        return value;
    }


    public static Person parse(String text) {
        return Arrays.stream(values()).filter(a->a.value.equalsIgnoreCase(text)).findAny().orElse(UNKNOWN);
    }

    public static final Set<Person> persons = Collections.unmodifiableSet(EnumSet.of(WOMAN, MAN));

}
