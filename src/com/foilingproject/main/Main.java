package com.foilingproject.main;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Print out what you want your first set to be like, Print it out like (a,b)");
        String input1 = scanner.nextLine().strip();
        System.out.println("Print out what you want your first set to be like, Print it out like (a,b)");
        String input2 = scanner.nextLine().strip();
        System.out.println(foil(input1, input2));
    }

    public static float foil(String input1, String input2) {
        float finalNum;
        float num1=0;
        float num2=0;
        float num3=0;
        float num4=0;
        //filter input to be used in math
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == ',') {
                num1 = Float.parseFloat(input1.substring(1, i));
                num2 = Float.parseFloat(input1.substring(i+1, input1.length()-1));
            }
        }
        for (int i = 0; i < input2.length(); i++) {
            if (input2.charAt(i) == ',') {
                num3 = Float.parseFloat(input2.substring(1, i));
                num4 = Float.parseFloat(input2.substring(i+1, input2.length()-1));
            }
        }
        finalNum = ((num1 * num3) + (num1 * num4) + (num2 * num3) + (num2 * num4));
        return finalNum;
    }
}
