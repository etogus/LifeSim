package com.mamedovga.lifesim.utils;

import com.mamedovga.lifesim.models.Country;

public class CountryUtils {
    public static Country[] getCountries()  {
        Country cnt1 = new Country("Россия");
        Country cnt2 = new Country("США");
        Country cnt3 = new Country("Китай");

        return new Country[] {cnt1, cnt2, cnt3};
    }
}