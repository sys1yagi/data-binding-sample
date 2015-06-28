package com.sys1yagi.databindingsample.tools;

public class Calculator {

    public static Integer plus(int left, int right) {
        return left + right;
    }

    public static Integer multi(int left, int right) {
        return left * right;
    }

    public static Integer digitsCount(int value) {
        return String.valueOf(value).length();
    }
}
