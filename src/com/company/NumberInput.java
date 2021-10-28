package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class NumberInput {

    public static void numberInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 10 numbers");

        // int input sætter input mængden til 10
        int input = 10;
        int[] numbers = new int[input];

        for (int i = 0; i < input; i++) {
            numbers[i] = scan.nextInt();
        }
        //Udskriver alt data (10 numre) som ligger inde i array'et
        System.out.println(Arrays.toString(numbers));

        /*int[] numbers1 = double[] divisionResult;
*/
        //double[] divisionResult = new double[input];
/*
        double divisionResult = double result;

        for (int j = 0; j < input; j++) {
            double result = numbers[j] / numbers[j+1];
        }

        System.out.println(divisionResult);*/ 
    }

}
