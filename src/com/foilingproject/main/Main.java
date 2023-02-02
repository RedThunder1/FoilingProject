package com.foilingproject.main;

import java.util.Scanner;
import java.util.StringJoiner;

import static com.foilingproject.main.complexFoiling.complexFoiling.complexFoiling;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Asks for the first set of numbers
        System.out.println("Print out what you want your first set to be like, Print it out like (a,b) or (ax2,b)");
        String input1 = scanner.nextLine();
        //Asks for the second set of numbers
        System.out.println("Print out what you want your first set to be like, Print it out like (a,b) or (ax2,b)");
        String input2 = scanner.nextLine();
        String in = input1.strip();
        String in2 = input2.strip();
        if (in.contains("x") || in2.contains("x")) {
            System.out.println(complexFoiling(in,in2));
        } else {
            //Checks if there was no error with the equation,  If there is it returns null and tells the user there was an error
            if (foil(in,in2) != null) {
                System.out.println(foil(in,in2));
            }
        }
    }

    //Function used for standard foiling, Complex foiling is in its own class
    public static Float foil(String input1, String input2) {
        float finalNum;
        float num1=0;
        float num2=0;
        float num3=0;
        float num4=0;
        //Check input before filtering
        try {
            //Filters 1st set of number
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
            System.out.println("The input you gave was incorrect!  Please try again.");
            System.out.println("The error was:\n" + e);
        }
        //returns 0 if the input is incorrect since I cant return null
        return null;
    }
}