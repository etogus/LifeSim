package com.mamedovga.lifesim.utils;

import com.mamedovga.lifesim.R;
import com.mamedovga.lifesim.models.BasicEvent;
import com.mamedovga.lifesim.models.MainCharacterViewModel;
import com.mamedovga.lifesim.models.MainCharacter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EventUtils {
    private static BasicEvent getBornEvent()  {
        List<BasicEvent> givenList = Arrays.asList(
                new BasicEvent("Первые звуки", R.drawable.baby,"bornMomCalls",
                        "Ваша мама зовёт вас к ней мягким голосом.\nВы чувствуете, что вам нужно ответить.\n\nКак вы ответите?",
                        new ArrayList<>(Arrays.asList("Сказать 'ма ма'", "Заплакать", "Сказать 'па па'"))));
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static BasicEvent getChildEvent()  {
        List<BasicEvent> givenList = Arrays.asList(
                new BasicEvent("Любимый напиток", R.drawable.drink,"childMomAsksDrink",
                        "Вы бегали весь день, и ваша мама спрашивает, что дать тебе попить.\n\nЧто вы выберите?",
                        new ArrayList<>(Arrays.asList("Вода", "Яблочный сок", "Молоко"))),
                new BasicEvent("Вакцинация", R.drawable.vaccine,"childMomTakesToDoc",
                        "Ваша мама отводит вас к врачу, чтобы сделать прививку.\n\nКак вы будете себя вести?",
                        new ArrayList<>(Arrays.asList("Оставаться спокойным", "Плюнуть на медсестру", "Заплакать"))),
                new BasicEvent("Детская площадка", R.drawable.toy,"childGirlTakesToy",
                        "Маленькая девочка, с которой вы играете, взяла вашу любимую игрушку\n\nЧто вы сделаете?",
                        new ArrayList<>(Arrays.asList("Поиграть вместе", "Забрать игрушку и уйти", "Отдать игрушку ей"))));
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private static BasicEvent getPrimarySchoolEvent()  {
        List<BasicEvent> givenList = Arrays.asList(
                new BasicEvent("Кинотеатр", R.drawable.cinema, "primarySchoolKidsAskToMovie",
                        "Соседские ребята приглашают вас посмотреть с ними новый популярный десткий фильм.\n\nЧто вы сделаете?",
                        new ArrayList<>(Arrays.asList("Пойти с ними", "Остаться дома", ""))),
                new BasicEvent("Семейный отдых", R.drawable.vacation,"primarySchoolParentsAskToVacation",
                        "Ваши родители хотят всей семьей отправиться отдыхать в Сингапур.\n\nЧто вы сделаете?",
                        new ArrayList<>(Arrays.asList("Быть благодарным", "Отказаться от поездки", "Побухтеть, но поехать"))));
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

//    private static String getMiddleSchoolEvent()  {
//        List<String> givenList = Arrays.asList(
//                "Эвент1-подросток",
//                "Эвент2-подросток",
//                "Эвент3-подросток");
//        Random rand = new Random();
//        return givenList.get(rand.nextInt(givenList.size()));
//    }
//
//    private static String getHighSchoolEvent()  {
//        List<String> givenList = Arrays.asList(
//                "Эвент1-старшая-школа",
//                "Эвент2-старшая-школа",
//                "Эвент3-старшая-школа");
//        Random rand = new Random();
//        return givenList.get(rand.nextInt(givenList.size()));
//    }
//
//    private static String getUniEvent()  {
//        List<String> givenList = Arrays.asList(
//                "Эвент1-универ \n",
//                "Эвент2-универ \n",
//                "Эвент3-универ \n");
//        Random rand = new Random();
//        return givenList.get(rand.nextInt(givenList.size()));
//    }
//
//    private static String getJobEvent()  {
//        List<String> givenList = Arrays.asList(
//                "Эвент1-работа",
//                "Эвент2-работа",
//                "Эвент3-работа");
//        Random rand = new Random();
//        return givenList.get(rand.nextInt(givenList.size()));
//    }
//
//    private static String getOldEvent()  {
//        List<String> givenList = Arrays.asList(
//                "Эвент1-пенсионер",
//                "Эвент2-пенсионер",
//                "Эвент3-пенсионер");
//        Random rand = new Random();
//        return givenList.get(rand.nextInt(givenList.size()));
//    }

    public static BasicEvent generateEvent(MainCharacterViewModel viewModel) {
        int age = viewModel.getAge().getValue();
        if(age <= 2) {
            return getBornEvent();
        }
        else if(age < 7) {
            return getChildEvent();
        }

        return getPrimarySchoolEvent();
//        else if(age < 16) {
//            return getPrimarySchoolEvent();
//        }
//        else if(age < 18) {
//            return getHighSchoolEvent();
//        }
//        else if(age < 23) {
//            return getUniEvent();
//        }
//        else if(age < 65) {
//            return getJobEvent();
//        }
//        return getOldEvent();
    }
}
