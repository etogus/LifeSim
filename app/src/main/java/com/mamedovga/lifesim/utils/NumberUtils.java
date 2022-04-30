package com.mamedovga.lifesim.utils;

import java.util.Arrays;
import java.util.Random;

public class NumberUtils {
    public static int getRandomNumber(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        int randomNumber = random.nextInt(diff + 1);
        randomNumber += min;
        return randomNumber;
    }

    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
}