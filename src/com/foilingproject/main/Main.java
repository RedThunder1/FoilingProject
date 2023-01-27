package com.foilingproject.main;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //gets first set of numbers
        System.out.println("Print out what you want your first set to be like, Print it out like (a,b)");
        String input1 = scanner.nextLine().strip();
        //gets second set of numbers
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
        //Check input before filtering
        try {
            //filter input to be used in math
                        //Filters 1st set of numbers
            if (input1.contains("x")) {
                //this will be hell so I'll do it later
                System.out.println("variables are not yet supported");
                return 0;
            }

            for (int i = 0; i < input1.length(); i++) {
                if (input1.charAt(i) == ',') {
                    num1 = Float.parseFloat(input1.substring(1, i));
                    num2 = Float.parseFloat(input1.substring(i+1, input1.length()-1));
                }
            }
            //filters 2nd set of numbers
            for (int i = 0; i < input2.length(); i++) {
                if (input2.charAt(i) == ',') {
                    num3 = Float.parseFloat(input2.substring(1, i));
                    num4 = Float.parseFloat(input2.substring(i+1, input2.length()-1));
                }
            }
            //the foiling math
            finalNum = ((num1 * num3) + (num1 * num4) + (num2 * num3) + (num2 * num4));
            return finalNum;
        } catch (Exception e) {
            //If input is incorrect it is caught here
            System.out.println("The input you gave was incorrect!");
        }
        //returns 0 if the input is incorrect since I cant return null
        return 0;
    }
}