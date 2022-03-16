package com.mamedovga.lifesim.utils;

import java.util.Random;

public class OtherUtils {
    public static int getRandomNumber(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        int randomNumber = random.nextInt(diff + 1);
        randomNumber += min;
        return randomNumber;
    }
}