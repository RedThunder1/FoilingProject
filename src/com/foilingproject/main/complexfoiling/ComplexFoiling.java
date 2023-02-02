package com.foilingproject.main.complexfoiling;

import java.util.*;

public class ComplexFoiling {


    //Foiling function used for complex foiling
    public static String complexFoiling(String input1, String input2) {
        String finalValue = "";

        //variables for storing the input
        String stringNum1 = "";
        int num1 = 0;
        int num1Exp = 0;

        String stringNum2 = "";
        int num2 = 0;
        int num2Exp = 0;

        String stringNum3 = "";
        int num3 = 0;
        int num3Exp = 0;

        String stringNum4 = "";
        int num4 = 0;
        int num4Exp = 0;

        //separate numbers in each set to their own String
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == ',') {
                stringNum1 = input1.substring(1, i);
                stringNum2 = input1.substring(i+1, input1.length()-1);
            }
        }
        for (int i = 0; i < input2.length(); i++) {
            if (input2.charAt(i) == ',') {
                stringNum3 = input2.substring(1, i);
                stringNum4 = input2.substring(i+1, input2.length()-1);
            }
        }

        //Detects if the number has a variable in it and separates the numbers and the exponent of the var
        //Only x is supported as a variable rn to make coding it a little easier,  I will add support for other characters to be vars
        for (int i = 0; i < stringNum1.length(); i++) {
            if (stringNum1.contains("x")) {
                if (stringNum1.charAt(i) == 'x') {
                    //Checks if there is an exponent after the var
                    num1 = Integer.parseInt(stringNum1.substring(0,i));
                    if (stringNum1.charAt(stringNum1.length()-1) == 'x') {
                        //sets the exponent to 1 if the number has a var but no exponent put after it
                        num1Exp = 1;
                    } else {
                        //sets the exponent after the var
                        num1Exp = Integer.parseInt(stringNum1.substring(i+1));
                    }
                }
            } else {
                //If there is no exponent it stays as zero
                num1 = Integer.parseInt(stringNum1);
                break;
            }
        }

        for (int i = 0; i < stringNum2.length(); i++) {
            if (stringNum2.contains("x")) {
                if (stringNum2.charAt(i) == 'x') {
                    num2 = Integer.parseInt(stringNum2.substring(0,i));
                    if (stringNum2.charAt(stringNum2.length()-1) == 'x') {
                        num2Exp = 1;
                    } else {
                        num2Exp = Integer.parseInt(stringNum2.substring(i+1));
                    }
                }
            } else {
                num2 = Integer.parseInt(stringNum2);
                break;
            }
        }
        for (int i = 0; i < stringNum3.length(); i++) {
            if (stringNum3.contains("x")) {
                if (stringNum3.charAt(i) == 'x') {
                    num3 = Integer.parseInt(stringNum3.substring(0,i));
                    if (stringNum3.charAt(stringNum3.length()-1) == 'x') {
                        num3Exp = 1;
                    } else {
                        num3Exp = Integer.parseInt(stringNum3.substring(i+1));
                    }
                }
            } else {
                num3 = Integer.parseInt(stringNum3);
                break;
            }
        }
        for (int i = 0; i < stringNum4.length(); i++) {
            if (stringNum4.contains("x")) {
                if (stringNum4.charAt(i) == 'x') {
                    num4 = Integer.parseInt(stringNum4.substring(0,i));
                    if (stringNum4.charAt(stringNum4.length()-1) == 'x') {
                        num4Exp = 1;
                    } else {
                        num4Exp = Integer.parseInt(stringNum4.substring(i+1));
                    }
                }
            } else {
                num4 = Integer.parseInt(stringNum4);
                break;
            }
        }
        //Here is the math for the foiling (This makes me want to die inside)
        //THIS CODE IS NOT FINAL.  This code can definitely be better and cleaned up a bit but ill do that once it works (and if I have the motivation too).
        int[] foiledNum1 = {num1 * num3, num1Exp + num3Exp};
        int[] foiledNum2 = {num1 * num4, num1Exp + num4Exp};
        int[] foiledNum3 = {num2 * num3, num2Exp + num3Exp};
        int[] foiledNum4 = {num2 * num4, num2Exp + num4Exp};
        boolean num1used = false;
        boolean num2used = false;
        boolean num3used = false;
        boolean num4used = false;
        ArrayList<Integer> exponents = new ArrayList<>();
        exponents.add(foiledNum1[1]);
        exponents.add(foiledNum2[1]);
        exponents.add(foiledNum3[1]);
        exponents.add(foiledNum4[1]);

        //Setting it to a set will remove duplicates, so we can check the size of the set to determine if there were similar values and go from there
        Set<Integer> finalizedExp = new HashSet<>(exponents);
        System.out.println(finalizedExp.size() + " different values (only 4 different values are supported right now)");
        System.out.println(exponents);

        //These checks need to be made better eventually
        switch (finalizedExp.size()) {
            case 4 -> {
                //If there are no similar values this code runs
                int firstNum = largest(exponents);
                if (firstNum == foiledNum1[1]) {
                    exponents.remove(0);
                    num1used = true;
                    finalValue = foiledNum1[0] + "x" + firstNum;
                } else if (firstNum == foiledNum2[1]) {
                    exponents.remove(1);
                    num2used = true;
                    finalValue = foiledNum2[0] + "x" + firstNum;
                } else if (firstNum == foiledNum3[1]) {
                    exponents.remove(2);
                    num3used = true;
                    finalValue = foiledNum3[0] + "x" + firstNum;

                } else {
                    exponents.remove(3);
                    num4used = true;
                    finalValue = foiledNum4[0] + "x" + firstNum;
                }
                System.out.println(exponents);

                //Checks for 2nd largest number and adds it to the final value
                int secondNum = largest(exponents);
                if (!num1used) {
                    if (secondNum == foiledNum1[1]) {
                        exponents.remove(Integer.valueOf(foiledNum1[1]));
                        num1used = true;
                        finalValue = finalValue + " " + foiledNum1[0] + "x" + secondNum;
                    }
                }
                if (!num2used) {
                    if (secondNum == foiledNum2[1]) {
                        exponents.remove(Integer.valueOf(foiledNum2[1]));
                        num2used = true;
                        finalValue = finalValue + " " + foiledNum2[0] + "x" + secondNum;
                    }
                }
                if (!num3used) {
                    if (secondNum == foiledNum3[1]) {
                        exponents.remove(Integer.valueOf(foiledNum3[1]));
                        num3used = true;
                        finalValue = finalValue + " " + foiledNum3[0] + "x" + secondNum;
                    }
                }
                if (!num4used) {
                    if (secondNum == foiledNum4[1]) {
                        exponents.remove(Integer.valueOf(foiledNum4[1]));
                        num4used = true;
                        finalValue = finalValue + " " + foiledNum4[0] + "x" + firstNum;
                    }
                }
                System.out.println(exponents);
                //Checks for 3rd largest number and adds it to the final value
                int thirdNum = largest(exponents);
                if (thirdNum == foiledNum1[1]) {
                    exponents.remove(Integer.valueOf(foiledNum1[1]));
                    finalValue = finalValue + " " + foiledNum1[0] + "x" + thirdNum;
                } else if (thirdNum == foiledNum2[1]) {
                    exponents.remove(Integer.valueOf(foiledNum2[1]));
                    finalValue = finalValue + " " + foiledNum2[0] + "x" + thirdNum;
                } else if (thirdNum == foiledNum3[1]) {
                    exponents.remove(Integer.valueOf(foiledNum3[1]));
                    finalValue = finalValue + " " + foiledNum3[0] + "x" + thirdNum;

                } else {
                    exponents.remove(Integer.valueOf(foiledNum4[1]));
                    finalValue = finalValue + " " + foiledNum4[0] + "x" + firstNum;
                }
                System.out.println(exponents);
                //Gets last value
                //Here we have to check to see if it has an exponent since its possible for this number to not have one
                if (exponents.get(0) == foiledNum1[1]) {
                    if (foiledNum1[1] == 0) {
                        finalValue = finalValue + " " + foiledNum1[0];
                    } else {
                        finalValue = finalValue + " " + foiledNum1[0] + "x" + foiledNum1[1];
                    }
                } else if (exponents.get(0) == foiledNum2[1]) {
                    if (foiledNum2[1] == 0) {
                        finalValue = finalValue + " " + foiledNum2[0];
                    } else {
                        finalValue = finalValue + " " + foiledNum2[0] + "x" + foiledNum2[1];
                    }
                } else if (exponents.get(0) == foiledNum3[1]) {
                    if (foiledNum3[1] == 0) {
                        finalValue = finalValue + " " + foiledNum3[0];
                    } else {
                        finalValue = finalValue + " " + foiledNum3[0] + "x" + foiledNum3[1];
                    }
                } else if (exponents.get(0) == foiledNum4[1]){
                    if (foiledNum4[1] == 0) {
                        finalValue = finalValue + " " + foiledNum4[0];
                    } else {
                        finalValue = finalValue + " " + foiledNum4[0] + "x" + foiledNum4[1];
                    }
                }
            }
            case 3, 2, 1 -> {

                return "unsupported right now!";

            }
            default -> {
                return "There was an error with the function! Please try again";
            }
        }


        System.out.println(exponents);

        return finalValue;
    }

    public static String getComplexFoiling(String input1, String input2) {
        return complexFoiling(input1, input2);
    }


    //Function to get the largest number out of an array since .max() only supports 2 values
    private static int largest(ArrayList<Integer> array)
    {
        int max = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        return max;
    }

    //Function to remove exponents from list
    private static Integer findInt(ArrayList<Integer> list, int num) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(num)) {
                return i;
            }
        }
        return null;
    }
}
