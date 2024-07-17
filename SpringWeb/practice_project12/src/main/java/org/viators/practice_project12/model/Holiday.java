package org.viators.practice_project12.model;

import lombok.Data;

@Data
public class Holiday {
    private final String day;
    private final String reason;
    private final Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }

    /* The commented code is no more required thanks to Lombok library (@Data).

    public Holiday(String day, String reason, Type type) {
        this.day = day;
        this.reason = reason;
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public String getReason() {
        return reason;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "day='" + day + '\'' +
                ", reason='" + reason + '\'' +
                ", type=" + type +
                '}';
    }
    */

}
