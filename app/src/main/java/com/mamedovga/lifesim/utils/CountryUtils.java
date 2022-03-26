package com.mamedovga.lifesim.utils;

import com.mamedovga.lifesim.R;
import com.mamedovga.lifesim.models.Country;

import java.util.HashMap;
import java.util.Map;

public class CountryUtils {

    public static Map<String, Integer> map;

    public static Country[] getCountries()  {
        Country cnt1 = new Country("Россия");
        Country cnt2 = new Country("США");
        Country cnt3 = new Country("Китай");
        Country cnt4 = new Country("Англия");
        Country cnt5 = new Country("Финляндия");
        Country cnt6 = new Country("Испания");
        Country cnt7 = new Country("Италия");
        Country cnt8 = new Country("Франция");
        Country cnt9 = new Country("Швеция");
        Country cnt10 = new Country("Германия");

        return new Country[] {cnt1, cnt2, cnt3, cnt4, cnt5, cnt6, cnt7, cnt8, cnt9, cnt10};
    }

    private static void mapInit() {
        map = new HashMap<String, Integer>();
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

    public static int getCountryFlag(String countryName) {
        mapInit();
        try {
            return map.get(countryName);
        } catch (NullPointerException e) {
            return R.drawable.russian_flag_icon_32;
        }
    }
}