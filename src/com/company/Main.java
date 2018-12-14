package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner kbInput = new Scanner(System.in);
        PrintWriter file = new PrintWriter("table.txt");

        String test = kbInput.nextLine();
        int A, B;
        int result = 0;

        file.write("A\tB\t" + test + "\n");

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                A = 1;
                B = 1;
            } else if (i == 1) {
                A = 1;
                B = 0;
            } else if (i == 2) {
                A = 0;
                B = 1;
            } else {
                A = 0;
                B = 0;
            }

            if (A == 1)
            {
                file.write("T\t");
            }
            else
            {
                file.write("F\t");
            }

            if (B == 1)
            {
                file.write("T\t");
            }
            else
            {
                file.write("F\t");
            }

            if (A == 1)
            {
                test = test.replace("A", "1");
            }
            else {
                test = test.replace("A", "0");
            }

            if (B == 1)
            {
                test = test.replace("B", "1");
            }
            else {
                test = test.replace("B", "0");
            }

            test = test.replace("&&", "*");
            test = test.replace("||", "+");
            result = compute(test);

            if (result >= 1)
            {
                file.write("T\n");
            }
            else
            {
                file.write("F\n");
            }
        }

        file.close();

        FileReader fr = new FileReader("table.txt");
        BufferedReader br = new BufferedReader(fr);
        String buffer;

        while ((buffer = br.readLine()) != null)
        {
            System.out.println(buffer);
        }

        br.close();
        fr.close();
    }

    static int compute(String equation) {
        int result = 0;
        String []byPluses = equation.split("\\+");
        for (String multipl : byPluses) {
            String []byMultipl = multipl.split("\\*");
            int multiplResult = 1;
            for (String operand : byMultipl) {
                multiplResult *= Integer.parseInt(operand);
            }
            result += multiplResult;
        }
        String myString = "1*(1+1)";
        //int myInt = Integer.parseInt(myString);
        System.out.println("myInt is " + myString);
        return result;
    }
}
