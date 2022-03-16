package com.mamedovga.lifesim.utils;

import com.mamedovga.lifesim.models.Person;

public class PersonUtils {
    public static void randomizeStats(Person person) {
        person.setKarma(randomizeKarma());
        int karma = person.getKarma();
        if(karma == 10)
            person.setPersonStats(100, 100, 100, 100);
        else if(karma >= 8) {
            person.setPersonStats(randomizeMood(80, 100), randomizeHealth(80, 100), randomizeIntelligence(80, 100), randomizeLooks(80, 100));
        }
        else if(karma >= 6) {
            person.setPersonStats(randomizeMood(60, 90), randomizeHealth(60, 90), randomizeIntelligence(60, 100), randomizeLooks(60, 90));
        }
        else if(karma >= 4) {
            person.setPersonStats(randomizeMood(40, 80), randomizeHealth(40, 80), randomizeIntelligence(40, 80), randomizeLooks(40, 80));
        }
        else if(karma <= 2) {
            person.setPersonStats(randomizeMood(0, 60), randomizeHealth(0, 60), randomizeIntelligence(0, 60), randomizeLooks(0, 60));
        }
    }

    private static int randomizeKarma() {
        return OtherUtils.getRandomNumber(0, 10);
    }

    private static int randomizeMood(int min, int max) {
        return OtherUtils.getRandomNumber(min, max);
    }

    private static int randomizeHealth(int min, int max) {
        return OtherUtils.getRandomNumber(min, max);
    }

    private static int randomizeIntelligence(int min, int max) {
        return OtherUtils.getRandomNumber(min, max);
    }

    private static int randomizeLooks(int min, int max) {
        return OtherUtils.getRandomNumber(min, max);
    }
}
