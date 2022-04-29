package com.mamedovga.lifesim.utils;

import com.mamedovga.lifesim.R;
import com.mamedovga.lifesim.models.Person;

public class PersonUtils {

    public static int[] maleAvatars = {R.drawable.scott_21, R.drawable.shaun_21};
    public static int[] femaleAvatars = {R.drawable.angel_21, R.drawable.chloe_21, R.drawable.daphne_21};

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

    public static String[] getMaleFirstNames(String country)  {
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

    public static String[] getFemaleFirstNames(String country)  {
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


    public static String getRandomFirstName(String gender, String country) {
        String[] names;
        if(gender.equals("male")) names = getMaleFirstNames(country);
        else names = getFemaleFirstNames(country);
        int randomNumber = NumberUtils.getRandomNumber(0, names.length - 1);
        return names[randomNumber];
    }

    public static String getRandomLastName(String gender, String country) {
        String[] names;
        if(gender.equals("female") && country.equals("Россия")) names = getWomanFirstNamesRussian();
        else names = getLastNames(country);
        int randomNumber = NumberUtils.getRandomNumber(0, names.length - 1);
        return names[randomNumber];
    }

    public static String[] getLastNames(String country)  {
        switch (country) {
            case "США":
            case "Англия":
                return new String[]{"Aaron", "Abbot", "Abraham", "Ackerman", "Addison",
                        "Adkins", "Armstrong", "Ashton", "Bailey", "Baker",
                        "Barnes", "Barrett", "Barton", "Baxter", "Beck", "Bell",
                        "Best", "Blake", "Blue", "Bonner", "Boyce", "Butler",
                        "Carter", "Cash", "Castle", "Chambers", "Chapman", "Clark",
                        "Clayton", "Clifford", "Cobb", "Cole", "Collins", "Colt",
                        "Conner", "Cook", "Cooper", "Cross", "Dallas", "Daniels",
                        "Davidson", "Dawson", "Delaney", "Eaton", "Elliot", "Elvis",
                        "Everett", "Fay", "Finch", "Fisher", "Forester", "Fowler",
                        "Gardner", "Gibbs", "Gill", "Grant", "Hanson", "Harlow",
                        "Harris", "Hawkins", "Hill", "Irving", "Jackson", "Jacobs",
                        "Johns", "Kirby", "Law", "Lowell", "Marlow", "Moon", "Palmer",
                        "Parker", "Paxton", "Perkins", "Peterson", "Pierce", "Powers",
                        "Rains", "Reeves", "Reynolds", "Rivers", "Robertson", "Rogers",
                        "Ross", "Rowe", "Rush", "Samuelson", "Shaw", "Stark", "Stone",
                        "Swanson", "Taylor", "Thompson", "Turner", "Underwood", "Vance",
                        "Walters", "Ward", "Webster", "Williams", "Winchester", "Winter",
                        "Wood", "Yates"};
            case "Китай":
                return new String[]{"Bai", "Chai", "Chan", "Chang", "Chen", "Cheung", "Chia",
                        "Chong", "Chou", "Chow", "Chu", "Du", "Fan", "Feng",
                        "Gao", "Guan", "Guo", "Han", "He", "Ho", "Hou",
                        "Hsu", "Hu", "Huang", "Jin", "Ko", "Kuang", "Kwan",
                        "Lam", "Lau", "Lee", "Li", "Lo", "Lu", "Lin", "Liu", "Luo",
                        "Ma", "Pan", "Pei", "Song", "Sung", "Tsui", "Wang", "Wen",
                        "Wong", "Wu", "Xie", "Xu", "Xun", "Yu", "Zhao"};
            case "Финляндия":
                return new String[]{"Aaltonen", "Heikki", "Heinonen", "Jokinen", "Korhonen",
                        "Laakkonen", "Lahtinen", "Linna", "Makinen", "Nieminen", "Partanen",
                        "Peltonen", "Rinne", "Saarinen", "Salminen", "Seppanen", "Toivonen",
                        "Vanhanen"};
            case "Испания":
                return new String[]{"Aguilar", "Alonso", "Alvarez", "Araujo", "Banderas",
                        "Barros", "Bautista", "Benitez", "Blanco", "Bolivar", "Bustos",
                        "Caballero", "Campos", "Cardozo", "Carrasco", "Casales",
                        "Castro", "Cortes", "Crespo", "Cruz", "Cuevas", "Delgado", "Espina",
                        "Ferro", "Flores", "Franco", "Fuentes", "Gallo", "Garcia", "Gaspar",
                        "Gil", "Gimenez", "Gomez", "Gonzales", "Guerra", "Guzman", "Herrera",
                        "Ibarra", "Juarez", "Lopez", "Lorenzo", "Lozano", "Molina", "Montero",
                        "Moralez", "Navarro", "Ochoa", "Ortega", "Paredes", "Perez", "Ramos"};
            case "Италия":
                return new String[]{"Acerbi", "Agani", "Ansaldi", "Antonini", "Armani", "Baggio",
                        "Bagnoli", "Baldini", "Bandini", "Belmonte", "Benini", "Berardi",
                        "Berti", "Biagi", "Bianco", "Campana", "Capello", "Carbone",
                        "Casale", "Cassano", "Cavallo", "Colombo", "Conti", "Crespo",
                        "Cuoco", "Damiani", "De Vito", "Di Napoli", "Esposito", "Falco",
                        "Ferri", "Franco", "Fusco", "Gaspari", "Lazzari", "Leone", "Lupo"};
            case "Франция":
                return new String[]{"Abel", "Allard", "Arnaud ", "Babin", "Bellamy", "Benoit",
                        "Blaise", "Borde", "Boucher", "Brodeur", "Bureau", "Calvin",
                        "Caron", "Charron", "Chauvin", "Clement", "Cloutier", "Colbert",
                        "Courtois", "Daniau", "Daviau", "Dubois", "Dufour", "Dumont",
                        "Fabre", "Fosse", "Gagne", "Germain", "Jean", "Lavigne", "Leclair"};
            case "Швеция":
                return new String[]{"Aberg", "Abramsson", "Adamsson", "Ahilberg", "Akerman",
                        "Akesson", "Alfson", "Berg", "Bergman", "Bjork",
                        "Blom", "Borg", "Bystrom", "Carlson", "Dahl", "Ek",
                        "Eklund", "Engman", "Ericson", "Falk", "Feldt",
                        "Fransson", "Grahn", "Hjort", "Holmberg", "Hult", "Isaksson"};
            case "Германия":
                return new String[]{"Albrecht", "Bachman", "Backer", "Bayer", "Bahr",
                        "Becker", "Blau", "Bocker", "Boehler", "Bohm",
                        "Brandt", "Braun", "Denzel", "Dohman", "Dressler", "Dreyer",
                        "Ebner", "Egger", "Engel", "Falk", "Faust", "Ferber", "Fiedler",
                        "Fischer", "Franke", "Frei", "Freud", "Fuchs", "Geissler",
                        "Gerber", "Graf", "Gunther", "Haase", "Habicht", "Halle", "Haumann"};
        }

        return new String[] {"Александров", "Алексеев", "Андреев", "Антонов", "Богданов",
                "Богомолов", "Борисов", "Федоров", "Иванов", "Константинов",
                "Козлов", "Кузнецов", "Лебедев", "Максимов", "Матвеев", "Мельников",
                "Михайлов", "Николаев", "Новиков", "Орлов", "Павлов", "Попов",
                "Романов", "Васильев", "Виноградов", "Волков", "Петров", "Яковлев",
                "Соколов", "Тимофеев", "Смирнов"};
    }

    public static String[] getWomanFirstNamesRussian() {
        return new String[] {"Александрова", "Алексеева", "Андреева", "Антонова", "Богданова",
                "Богомолова", "Борисова", "Федорова", "Иванова", "Константинова",
                "Козлова", "Кузнецова", "Лебедева", "Максимова", "Матвеева", "Мельникова",
                "Михайлова", "Николаева", "Новикова", "Орлова", "Павлова", "Попова",
                "Романова", "Васильева", "Виноградова", "Волкова", "Петрова", "Яковлева",
                "Соколова", "Тимофеева", "Смирнова"};
    }

}