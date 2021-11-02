package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class NumberInputAndDivision {

    //Bruges til at regne gennemsnittet og udskrives senere i Numberinput()
    public static double snit(int[] numbers, int input){

        //Dividerer tallene i array'et
        double sum = 0;
        int i;
        for (i = 0; i < input; i++)
            sum += numbers[i];

        return sum / input;
    }
    static void loadFromFile(int[] numbers, int input) {
        try {
            File myObj = new File("MyFile1.txt");
            Scanner in = new Scanner(myObj);

            for (int i = 0; i < input; i++)
                numbers[i] =in.nextInt();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    static void writeToFile(int [] numbers, int input) {
        try {
            PrintWriter ud = new PrintWriter("MyFile1.txt");
            for (int i = 0; i < input; i++)
                //Udskriv på hver sin linje
                //ud.println(numbers[i]);

                //Udskriver med mellemrum imellem de inputs man har fået, på en linje
                ud.format("%d ", numbers[i]);
            ud.close();
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public static void numberInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 10 numbers");


        // int input sætter input mængden til 10
        int input = 10;
        int[] numbers = new int[input];
        int[] numbers2 = new int[input];

        for (int i = 0; i < input; i++) {
            numbers[i] = scan.nextInt();
        }
        //Udskriver alt data (10 numre) som ligger inde i array'et
        System.out.println(Arrays.toString(numbers));

        writeToFile(numbers,input);
        loadFromFile(numbers2, input);
        System.out.println(Arrays.toString(numbers2));

        //Efterfølgende regner gennemsnit
        double g;
        g = snit(numbers,input); //Beder om numbers og input
        System.out.println(g);

    }
    //TODO try og catch for at smide ind i textfil
    //TODO den kører systemet indtil at der sker en fejl ved en catch

}
