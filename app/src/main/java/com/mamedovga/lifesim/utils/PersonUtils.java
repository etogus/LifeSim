package com.mamedovga.lifesim.utils;

import com.mamedovga.lifesim.models.Person;

public class PersonUtils {
    public static void randomizeStats(Person person) {
        person.setKarma(randomizeKarma());
        int karma = person.getKarma();
        if(karma == 10)
            person.setPersonStats(100, 100, 100, 100, 100);
        else if(karma >= 8) {
            person.setPersonStats(randomizeMood(80, 100), randomizeHealth(80, 100), randomizeIntelligence(80, 100), randomizeLooks(80, 100), randomizeEnergy(80, 100));
        }
        else if(karma >= 6) {
            person.setPersonStats(randomizeMood(60, 90), randomizeHealth(60, 90), randomizeIntelligence(60, 100), randomizeLooks(60, 90), randomizeEnergy(60, 90));
        }
        else if(karma >= 4) {
            person.setPersonStats(randomizeMood(40, 80), randomizeHealth(40, 80), randomizeIntelligence(40, 80), randomizeLooks(40, 80), randomizeEnergy(40, 80));
        }
        else if(karma <= 2) {
            person.setPersonStats(randomizeMood(0, 60), randomizeHealth(0, 60), randomizeIntelligence(0, 60), randomizeLooks(0, 60), randomizeEnergy(0, 60));
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

    private static int randomizeEnergy(int min, int max) {
        return OtherUtils.getRandomNumber(min, max);
    }

    public static String[] getMaleNames(String country)  {
        if(country.equals("США") || country.equals("Англия")) {
            return new String[] {"Anthony", "Adam", "Alex", "Aaron", "Brian",
                                "Brandon", "Bradley", "Brett", "Billy", "Bobby",
                                "Bruce", "Craig", "Carlos", "Chris", "Chad", "Casey",
                                "Cody", "Curtis", "David", "Douglas", "Dale", "Daniel",
                                "Donald", "Dan", "Derek", "Dustin", "Edward", "Ewan",
                                "Eric", "Eugene", "Frank", "Fred", "Floyd", "Gary",
                                "Glenn", "Henry", "Hugh", "Harry", "Ian", "John",
                                "Jason", "James", "Jack", "Mike", "Mark", "Oliver",
                                "Steven", "Sean", "Scott", "Seth", "Thomas", "Tyler",
                                "Tony", "Troy", "Todd", "Tommy", "Zane", "Zachary"};
        } else if(country.equals("Китай")) {
            return new String[] {"Ah", "An", "Bai", "Bao", "Bo", "Chang", "Chao",
                                "Chen", "Cheng", "Chin", "Da", "Fai", "Fang", "Fu",
                                "Han", "Hong", "Ho", "Kun", "Li", "Lin", "Ping",
                                "Shi", "Shun", "Tai", "Wei", "Wen", "Xing", "Xun",
                                "Yan", "Yin", "Zan", "Zhi"};
        } else if(country.equals("Финляндия")) {
            return new String [] {"Aapo", "Ale", "Alvar", "Edvin", "Erno", "Frans",
                                "Fredrik", "Ismo", "Jarmo", "Lasse", "Matti", "Mikko",
                                "Olavi", "Petri", "Risto", "Seppo", "Simo", "Taavi",
                                "Tomi", "Ville"};
        } else if(country.equals("Испания")) {
            return new String[]{"Abelardo", "Aldo", "Alejandro", "Alfonso", "Alfredo", "Alvaro",
                    "Andres", "Antonio", "Aurelio", "Benito", "Bernardo", "Carlos",
                    "Cesar", "Danilo", "Eduardo", "Emilio", "Enrique", "Esteban",
                    "Fabio", "Felipe", "Gustavo", "Hector", "Ignacio", "Jose",
                    "Leonardo", "Luis", "Marco", "Mario", "Miguel", "Paco", "Pedro",
                    "Ramon", "Roberto", "Rodrigo", "Sancho", "Santos", "Sergio"};
        } else if(country.equals("Италия")) {
            return new String[]{"Alessandro", "Angelo", "Antonio", "Cesare", "Dante", "Domenico",
                    "Emilio", "Enzo", "Fabio", "Franko", "Mario", "Marco",
                    "Romano", "Romolo", "Sergio", "Silvio", "Tito", "Vitale",
                    "Vito"};
        } else if(country.equals("Франция")) {
            return new String[]{"Ames", "Astor", "Berle ", "Boyce", "Butch", "Butler",
                    "Calvin", "Chandler", "Chevy", "Corbett", "Corbin", "Darnell",
                    "Delano", "Dorsey", "Durant", "Falcon", "Gaston", "Louis",
                    "Mason", "Noel", "Pacey", "Percy", "Purcell", "Rich",
                    "Rick", "Seymour", "Spencer", "Terrell", "Trey", "Tristan", "Vern"};
        }


        return new String[] {"Александр", "Алексей", "Альберт", "Анатолий", "Андрей",
                            "Богдан", "Борис", "Валерий", "Василий", "Виталий",
                            "Георгий", "Дмитрий", "Евгений", "Егор", "Иван", "Игорь",
                            "Илья", "Константин", "Леонид", "Максим", "Михаил", "Никита",
                            "Олег", "Павел", "Петр", "Руслан", "Сергей", "Степан",
                            "Тимур", "Тимофей", "Федор"};


        // return new String[] {"Россия", "США", "Китай", "Англия", "Финляндия", "Испания",
        //                    "Италия", "Франция", "Швеция", "Германия"};
    }


    public static String randomizeName(String gender, String country) {
        return "";
    }
}