package com.mamedovga.lifesim.utils;

public class StringUtils {
    public static boolean isStringLetterOnly(String s) {
        return s.chars().allMatch(Character::isLetter);
    }
}
