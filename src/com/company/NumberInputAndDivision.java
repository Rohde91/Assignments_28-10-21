package com.company;

import java.io.*;
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

    static void skriv(){
        try {
            PrintWriter ud = new PrintWriter("MyFileEks.txt");
            int i = 1;
            String navn = "Bob";
            float tal = (float) 1.2;
            //format bruges til mellemrum, dette sker sammenkoblet med %d (integer), %s (String), %f(float)
            ud.format("%d %s %f", i, navn, tal);
            ud.close();

        }
        catch (FileNotFoundException exception){
            exception.printStackTrace();
        }

    }

    //datainput filer:
    static void writeDataFile(){
        try {
            DataOutputStream output = new DataOutputStream(new FileOutputStream("tempFile.dat"));
            int i = 1;
            String navn = "Ross";
            float tal = (float) 2.32;
            output.writeInt(i);
            output.writeUTF(navn);
            output.writeFloat(tal);
            output.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    static void readDataFile(){
        try {
            DataInputStream input = new DataInputStream(new FileInputStream("tempFile.dat"));
            int i;
            String navn;
            float tal;
            i=input.readInt();
            navn = input.readUTF();
            tal = input.readFloat();

            System.out.format("%d %s %f", i, navn, tal);
            input.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    //Funktionen tager et objekt
    static void skriv2(Person p){
        try {
            PrintWriter ud = new PrintWriter("MyFileEks2.txt");
            //format bruges til mellemrum, dette sker sammenkoblet med %d (integer), %s (String), %f(double)
            ud.format("%d %s %f", p.getNr(), p.getNavn(), p.getTal());
            ud.close();

        }
        catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
    }

    //returner person
    static Person indtxtFil(){

        Person p = new Person();
        try {
            File in = new File("MyFileEks2.txt");
            Scanner scan = new Scanner(in);
            p.setNr(scan.nextInt());
            p.setNavn(scan.next());
            p.setTal(scan.nextDouble());
            scan.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }

    public static void numberInput() {
       /* Scanner scan = new Scanner(System.in);
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
*/
        //bruger nu funktionen skriv.
       /* skriv();
        writeDataFile();
        readDataFile();
*/
       // Person p = new Person(2,"Bobs", 9.2);
      //  skriv2(p);
       // indtxtFil();

        Person q;
        q = indtxtFil();
        System.out.format("\n%d %s %f", q.getNr(), q.getNavn(), q.getTal());


    }
    //TODO try og catch for at smide ind i textfil
    //TODO den kører systemet indtil at der sker en fejl ved en catch

}
