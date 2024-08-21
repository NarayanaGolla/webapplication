package com.web.application.dom;

import java.util.Comparator;

public class RegisterComparators {
    public static Comparator<Register> byId() {
        return Comparator.comparingLong(Register::getId);
    }

    public static Comparator<Register> byName() {
        return Comparator.comparing(Register::getUserName);
    }
}
