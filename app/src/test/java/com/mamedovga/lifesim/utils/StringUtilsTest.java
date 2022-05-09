package com.mamedovga.lifesim.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void isStringLetterOnly() {
        String input = "Wasd1";
        boolean output = StringUtils.isStringLetterOnly(input);
        assertFalse(output);
    }
}