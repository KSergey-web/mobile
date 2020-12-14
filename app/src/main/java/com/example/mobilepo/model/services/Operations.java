package com.example.mobilepo.model.services;

public class Operations {

    private static int n1,n2;

    private  static void fromString(String str1, String str2){
        if ( !str1.isEmpty()) {
            n1 = Integer.parseInt(str1);
        }
        else n1 = 0;
        if (!str2.isEmpty()) {
            n2 = Integer.parseInt(str2);
        }
        else n2 = 0;
    }

    public static String sum(String str1, String str2){
        fromString(str1,str2);
        int result = n1 + n2;
        return Integer.toString(result);
    }

    public static String mult(String str1, String str2){
        fromString(str1,str2);
        int result = n1 * n2;
        return Integer.toString(result);
    }
}
