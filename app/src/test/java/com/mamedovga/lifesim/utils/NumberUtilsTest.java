package com.mamedovga.lifesim.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberUtilsTest {

    @Test
    public void contains() {
        int[][] input1 = {{1, 2}, {9, 8}, {4, 6}};
        int[] input2 = {9, 8};
        boolean output = NumberUtils.contains(input1, input2);
        assertTrue(output);
    }
}