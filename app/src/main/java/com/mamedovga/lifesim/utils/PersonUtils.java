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
        return NumberUtils.getRandomNumber(0, 10);
    }

    private static int randomizeMood(int min, int max) {
        return NumberUtils.getRandomNumber(min, max);
    }

    private static int randomizeHealth(int min, int max) {
        return NumberUtils.getRandomNumber(min, max);
    }

    private static int randomizeIntelligence(int min, int max) {
        return NumberUtils.getRandomNumber(min, max);
    }

    private static int randomizeLooks(int min, int max) {
        return NumberUtils.getRandomNumber(min, max);
    }

    private static int randomizeEnergy(int min, int max) {
        return NumberUtils.getRandomNumber(min, max);
    }

    public static String[] getMaleNames(String country)  {
        switch (country) {
            case "США":
            case "Англия":
                return new String[]{"Anthony", "Adam", "Alex", "Aaron", "Brian",
                        "Brandon", "Bradley", "Brett", "Billy", "Bobby",
                        "Bruce", "Craig", "Carlos", "Chris", "Chad", "Casey",
                        "Cody", "Curtis", "David", "Douglas", "Dale", "Daniel",
                        "Donald", "Dan", "Derek", "Dustin", "Edward", "Ewan",
                        "Eric", "Eugene", "Frank", "Fred", "Floyd", "Gary",
                        "Glenn", "Henry", "Hugh", "Harry", "Ian", "John",
                        "Jason", "James", "Jack", "Mike", "Mark", "Oliver",
                        "Steven", "Sean", "Scott", "Seth", "Thomas", "Tyler",
                        "Tony", "Troy", "Todd", "Tommy", "Zane", "Zachary"};
            case "Китай":
                return new String[]{"Ah", "An", "Bai", "Bao", "Bo", "Chang", "Chao",
                        "Chen", "Cheng", "Chin", "Da", "Fai", "Fang", "Fu",
                        "Han", "Hong", "Ho", "Kun", "Li", "Lin", "Ping",
                        "Shi", "Shun", "Tai", "Wei", "Wen", "Xing", "Xun",
                        "Yan", "Yin", "Zan", "Zhi"};
            case "Финляндия":
                return new String[]{"Aapo", "Ale", "Alvar", "Edvin", "Erno", "Frans",
                        "Fredrik", "Ismo", "Jarmo", "Lasse", "Matti", "Mikko",
                        "Olavi", "Petri", "Risto", "Seppo", "Simo", "Taavi",
                        "Tomi", "Ville"};
            case "Испания":
                return new String[]{"Abelardo", "Aldo", "Alejandro", "Alfonso", "Alfredo", "Alvaro",
                        "Andres", "Antonio", "Aurelio", "Benito", "Bernardo", "Carlos",
                        "Cesar", "Danilo", "Eduardo", "Emilio", "Enrique", "Esteban",
                        "Fabio", "Felipe", "Gustavo", "Hector", "Ignacio", "Jose",
                        "Leonardo", "Luis", "Marco", "Mario", "Miguel", "Paco", "Pedro",
                        "Ramon", "Roberto", "Rodrigo", "Sancho", "Santos", "Sergio"};
            case "Италия":
                return new String[]{"Alessandro", "Angelo", "Antonio", "Cesare", "Dante", "Domenico",
                        "Emilio", "Enzo", "Fabio", "Franko", "Mario", "Marco",
                        "Romano", "Romolo", "Sergio", "Silvio", "Tito", "Vitale",
                        "Vito"};
            case "Франция":
                return new String[]{"Ames", "Astor", "Berle ", "Boyce", "Butch", "Butler",
                        "Calvin", "Chandler", "Chevy", "Corbett", "Corbin", "Darnell",
                        "Delano", "Dorsey", "Durant", "Falcon", "Gaston", "Louis",
                        "Mason", "Noel", "Pacey", "Percy", "Purcell", "Rich",
                        "Rick", "Seymour", "Spencer", "Terrell", "Trey", "Tristan", "Vern"};
            case "Швеция":
                return new String[]{"Alvar", "Arvid", "Casper", "Edvard", "Edvin",
                        "Einar", "Erling", "Frans", "Fredrik", "Georg",
                        "Harald", "Hasse", "Holger", "Klas", "Mats", "Niklas",
                        "Olle", "Ruben", "Stefan", "Sten", "Ville"};
            case "Германия":
                return new String[]{"Aart", "Abbe", "Adler", "Aldo", "Arne",
                        "Bedrich", "Bach", "Berman", "Brant", "Brecht",
                        "Dieter", "Dietz", "Dolph", "Eckhart", "Elmo", "Fitz",
                        "Frank", "Fred", "Gaston", "Gert", "Gil", "Hahn", "Gustav",
                        "Harman", "Harris", "Hein", "Heinz", "Heller", "Hendrick",
                        "Hugh", "Hugo", "Kahn", "Karl", "Konrad", "Liam", "Luther"};
        }

        return new String[] {"Александр", "Алексей", "Альберт", "Анатолий", "Андрей",
                            "Богдан", "Борис", "Валерий", "Василий", "Виталий",
                            "Георгий", "Дмитрий", "Евгений", "Егор", "Иван", "Игорь",
                            "Илья", "Константин", "Леонид", "Максим", "Михаил", "Никита",
                            "Олег", "Павел", "Петр", "Руслан", "Сергей", "Степан",
                            "Тимур", "Тимофей", "Федор"};
    }

    public static String[] getFemaleNames(String country)  {
        switch (country) {
            case "США":
            case "Англия":
                return new String[]{"Amanda", "Andrea", "Angela", "Ashley", "Audrey",
                        "Barbara", "Beverly", "Callie", "Chelsea", "Clara",
                        "Daisy", "Dana", "Diana", "Gina", "Haley", "Harper",
                        "Harley", "Heather", "Holly", "Ivy", "June", "Kim",
                        "Laura", "Madison", "Marissa", "Misty", "Nora", "Olivia",
                        "Paige", "Piper", "Polly", "Priscilla", "Riley", "Scarlett",
                        "Sienna", "Stella", "Summer", "Vanessa"};
            case "Китай":
                return new String[]{"Ah", "Ai", "An", "Bai", "Bao", "Bo", "Chen", "Chin",
                        "Fa", "Fan", "Fang", "Fen", "Fu", "Guo", "Hai",
                        "Han", "He", "Heng", "Hua", "Jun", "Lan", "Lei", "Lian",
                        "Lim", "Lin", "Mei", "Min", "Mu", "Qi", "Qiu",
                        "Ru", "Shi", "Shu", "Tai", "Wei", "Wen", "Yin", "Yun"};
            case "Финляндия":
                return new String[]{"Adda", "Anja", "Cecilia", "Fanni", "Fredrika", "Helmi",
                        "Jonna", "Kaisa", "Kata", "Krista", "Maija", "Mari",
                        "Margareta", "Mikaela", "Olivia", "Rebekka", "Reeta", "Silja",
                        "Tarja"};
            case "Испания":
                return new String[]{"Alba", "Antonia", "Aurora", "Bonita", "Cassandra",
                        "Cecilia", "Celia", "Cierra", "Clara", "Delia", "Dolores",
                        "Emilia", "Fabiola", "Gloria", "Isa", "Jade", "Laura",
                        "Lola", "Marissa", "Micaela", "Nina", "Rosa", "Sierra",
                        "Tia", "Valentina"};
            case "Италия":
                return new String[]{"Alessandra", "Amanda", "Angela", "Angelica", "Aurora",
                        "Barbara", "Beatrice", "Camilla", "Cara", "Cassandra", "Cecilia",
                        "Celia", "Clara", "Clarissa", "Delia", "Diana", "Donna", "Emilia",
                        "Filippa", "Flavia", "Flora", "Francesca", "Gina", "Isabella",
                        "Laura", "Lia", "Marissa", "Nora", "Olivia", "Priscilla", "Renata",
                        "Rosalia", "Sabrina", "Serena", "Stella", "Valentina", "Veronica",
                        "Viola", "Virginia"};
            case "Франция":
                return new String[]{"Alice", "Amy", "Barbara ", "Cloe", "Colette", "Courtney",
                        "Darcy", "Fabiola", "Jolie", "Lacey", "Lorena", "Macy",
                        "Mallory", "Nicoline", "Noelle", "Paris", "Raine", "Rochelle",
                        "Sheryl", "Tracy"};
            case "Швеция":
                return new String[]{"Agneta", "Anja", "Camilla", "Carin", "Edit",
                        "Eira", "Elin", "Elise", "Filippa", "Fredrika",
                        "Freja", "Hedda", "Hella", "Helmi", "Hildur", "Jonna",
                        "Kajsa", "Karina", "Linn", "Margareta", "Rita", "Siri"};
            case "Германия":
                return new String[]{"Ada", "Adele", "Amelia", "Aubrey", "Belinda",
                        "Berta", "Bianca", "Carly", "Carol", "Charlie", "Emma",
                        "Evelyn", "Freda", "Frederica", "Frida", "Gerda", "Helma",
                        "Linda", "Lulu", "Marla", "Matilda", "Millie", "Mina",
                        "Robin", "Velma", "Yvette", "Zelda"};
        }

        return new String[] {"Анастасия", "Алина", "Александра", "Анна", "Валерия",
                "Варвара", "Василиса", "Вероника", "Виктория", "Дарья",
                "Евгения", "Екатерина", "Елена", "Елизавета", "Ирина", "Карина",
                "Ксения", "Маргарита", "Мария", "Наталья", "Нина", "Оксана",
                "Ольга", "Полина", "Светлана", "София", "Татьяна", "Юлия"};
    }


    public static String getRandomName(String gender, String country) {
        String[] names;
        if(gender.equals("male")) names = getMaleNames(country);
        else names = getFemaleNames(country);
        int randomNumber = NumberUtils.getRandomNumber(0, names.length - 1);
        return names[randomNumber];
    }
}