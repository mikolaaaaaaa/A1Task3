package com.mikola.a1task3.entity;


public enum Period {
    DAY("day"),
    MONTH("month"),
    QUARTER("quarter"),
    YEAR("year");

    private String value;
    Period(String period) {
        this.value = period;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
