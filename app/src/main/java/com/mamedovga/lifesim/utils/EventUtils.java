package com.mamedovga.lifesim.utils;

import com.mamedovga.lifesim.models.MainCharacterViewModel;
import com.mamedovga.lifesim.models.MainCharacter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EventUtils {
    private static String getBornEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-родился",
                "Эвент2-родился",
                "Эвент3-родился");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getBabyEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-малыш",
                "Эвент2-малыш",
                "Эвент3-малыш");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getChildEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-ребёнок",
                "Эвент2-ребёнок",
                "Эвент3-ребёнок");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getPrimarySchoolEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-школьник",
                "Эвент2-школьник",
                "Эвент3-школьник");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getMiddleSchoolEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-подросток",
                "Эвент2-подросток",
                "Эвент3-подросток");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getHighSchoolEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-старшая-школа",
                "Эвент2-старшая-школа",
                "Эвент3-старшая-школа");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getUniEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-универ \n",
                "Эвент2-универ \n",
                "Эвент3-универ \n");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getJobEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-работа",
                "Эвент2-работа",
                "Эвент3-работа");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static String getOldEvent()  {
        List<String> givenList = Arrays.asList(
                "Эвент1-пенсионер",
                "Эвент2-пенсионер",
                "Эвент3-пенсионер");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    public static String generateEvent(MainCharacter mainCharacter) {
        int age = mainCharacter.getAge();
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

    public static String generateEvent(MainCharacterViewModel viewModel) {
        int age = viewModel.getAge().getValue();
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
