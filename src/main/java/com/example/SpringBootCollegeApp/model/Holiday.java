package com.example.SpringBootCollegeApp.model;

import lombok.Data;

@Data
public class Holiday extends BaseEntity {

    private final String day;
    private final String reason;
    private final Type type;

    public enum Type{
        FEDERAL,
        FESTIVAL
    }

}
