package com.arteni.mag.Models;

public enum OrderStatus {
    CREATED("CREATED"),
    IN_PROGRESS("IN_PROGRESS"), //
    PAYED("PAYED"), //
    NONEXISTENT("NONEXISTENT"), //
    CANCELLED("CANCELLED");

    public String code;

    OrderStatus(String s) {
        this.code = s;
    }

    public static OrderStatus getCodeFromString(String s) {
        switch (s) {
            case "CREATED":
                return CREATED;
            case "NONEXISTENT":
                return NONEXISTENT;
            case "PAYED":
                return PAYED;
            case "CANCELLED":
                return CANCELLED;
            default:
                return CREATED;
        }
    }

    @Override
    public String toString() {
        return this.code;
    }
}
