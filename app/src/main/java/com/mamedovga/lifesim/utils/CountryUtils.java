package com.mamedovga.lifesim.utils;

import com.mamedovga.lifesim.R;

import java.util.HashMap;
import java.util.Map;

public class CountryUtils {

    public static Map<String, Integer> map;

    static {
        map = new HashMap<>();
        map.put("Россия", R.drawable.russian_flag_icon_32);
        map.put("США", R.drawable.usa_flag_icon_32);
        map.put("Китай", R.drawable.china_flag_icon_32);
        map.put("Англия", R.drawable.england_flag_icon_32);
        map.put("Финляндия", R.drawable.finland_flag_icon_32);
        map.put("Испания", R.drawable.spain_flag_icon_32);
        map.put("Италия", R.drawable.italy_flag_icon_32);
        map.put("Франция", R.drawable.france_flag_icon_32);
        map.put("Швеция", R.drawable.sweden_flag_icon_32);
        map.put("Германия", R.drawable.germany_flag_icon_32);
    }

    public static String[] getCountries()  {
        return new String[] {"Россия", "США", "Китай", "Англия", "Финляндия", "Испания", "Италия", "Франция", "Швеция", "Германия"};
    }

    public static int getCountryFlag(String countryName) {
        try {
            return map.get(countryName);
        } catch (NullPointerException e) {
            return R.drawable.russian_flag_icon_32;
        }
    }
}