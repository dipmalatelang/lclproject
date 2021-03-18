package com.example.lcl.util;

public class Helpers {

    public static String amountFormatter(long input){
        String amount = "";
        if (input != 0) {
            int digits = String.valueOf(input).length();
            double n;
            switch (digits) {
                case 3:
                    n = input / 100;
                    n = Math.round(n);
                    amount = n + "k";

            }
        }
        return amount;
    }
}
