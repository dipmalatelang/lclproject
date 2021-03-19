package com.example.lcl.util;

public class Helpers {

    public static String convertCurrency(long number) {
        int length = String.valueOf(number).length();
        String currency = "";

        if (length == 4 || length == 5) {
            number = number / 1000;
            number = Math.round(number);
            currency = number + "K";
        } else if (length == 6 || length == 7) {
            number = number / 100000;
            number = Math.round(number);
            currency = number + "Lac";
        } else if (length == 8 || length == 9) {
            number = number / 10000000;
            number = Math.round(number);
            currency = number + "Cr";
        }
        return currency;
    }

}
