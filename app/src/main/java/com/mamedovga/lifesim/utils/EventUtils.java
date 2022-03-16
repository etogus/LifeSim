package com.mamedovga.lifesim.utils;

import com.mamedovga.lifesim.models.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EventUtils {
    private static String getBornEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-родился \n \n",
                "Эвент2-родился \n \n",
                "Эвент3-родился \n \n");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getBabyEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-малыш \n \n",
                "Эвент2-малыш \n \n",
                "Эвент3-малыш \n \n");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getChildEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-ребёнок \n \n",
                "Эвент2-ребёнок \n \n",
                "Эвент3-ребёнок \n \n");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getPrimarySchoolEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-школьник \n \n",
                "Эвент2-школьник \n \n",
                "Эвент3-школьник \n \n");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getMiddleSchoolEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-подросток \n \n",
                "Эвент2-подросток \n \n",
                "Эвент3-подросток \n \n");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getHighSchoolEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-старшая-школа \n \n",
                "Эвент2-старшая-школа \n \n",
                "Эвент3-старшая-школа \n \n");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getUniEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-универ \n \n",
                "Эвент2-универ \n \n",
                "Эвент3-универ \n \n");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getJobEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-работа \n \n",
                "Эвент2-работа \n \n",
                "Эвент3-работа \n \n");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getOldEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-пенсионер \n \n",
                "Эвент2-пенсионер \n \n",
                "Эвент3-пенсионер \n \n");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    public static String generateEvent(Person person) {
        int age = person.getAge();
        if(age == 0) {
            return getBornEvent();
        }
        else if(age < 3) {
            return getBabyEvent();
        }
        else if(age < 7) {
            return getChildEvent();
        }
        else if(age < 12) {
            return getPrimarySchoolEvent();
        }
        else if(age < 16) {
            return getPrimarySchoolEvent();
        }
        else if(age < 18) {
            return getHighSchoolEvent();
        }
        else if(age < 23) {
            return getUniEvent();
        }
        else if(age < 65) {
            return getJobEvent();
        }
        return getOldEvent();
    }
}
