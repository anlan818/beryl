package com.hc.java.java8;

import java.util.Optional;

public class Java8 {


    public static void main(String[] args) {
        optional();
    }

    private static void optional() {
        // 判空去重
        String s = "  111 2";
        String s1 = Optional.ofNullable(s).map(String::trim).orElse("1");
    }
}
