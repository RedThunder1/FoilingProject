package com.foilingproject.main.complexFoiling;

public class complexFoiling {

    //Foiling function used for complex foiling
    public static String complexFoiling(String input1, String input2) {
        String finalValue = "test";

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
                    System.out.println(stringNum1);
                    num1 = Integer.parseInt(stringNum1.substring(0,i));
                    if (stringNum1.charAt(stringNum1.length()-1) == 'x') {
                        num1Exp = 1;
                    } else {
                        num1Exp = Integer.parseInt(stringNum1.substring(i+1));
                    }
                }
            } else {
                num1 = Integer.parseInt(stringNum1);
                break;
            }
        }

        for (int i = 0; i < stringNum2.length(); i++) {
            if (stringNum2.contains("x")) {
                if (stringNum2.charAt(i) == 'x') {
                    //Checks if there is an exponent after the var
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
                    //Checks if there is an exponent after the var
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
                    //Checks if there is an exponent after the var
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
        //Here is the math for the foiling
        //This makes me want to die inside
        int foiledNum1 = num1 * num3;
        int foiledNum2 = num1 * num4;
        int foiledNum3 = num2 * num3;
        int foiledNum4 = num2 * num4;



        return finalValue;
    }
}
