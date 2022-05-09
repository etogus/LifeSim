package com.mamedovga.lifesim.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountryUtilsTest {

    @Test
    public void getCountryFlag() {
        String input = "Испания";
        int output = CountryUtils.getCountryFlag(input);
        int expected = 2131165424;
        assertEquals(expected, output);
    }
}