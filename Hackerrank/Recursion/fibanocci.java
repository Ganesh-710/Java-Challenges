package Hackerrank.Recursion;

import java.util.Scanner;

public class fibanocci implements Cloneable{

    private static int a = 1;
    private static int b = a;

    public static void main(String[] args) {

        Scanner scan =  new Scanner(System.in);
        System.out.println("Enter the number");
        System.out.println(fibanocci(scan.nextInt()));

    }

    private static int fibanocci(int n) {

        if (n > 2) {
            return fibanocci(n-1) + fibanocci(n-2);
        } else {
            return 1;
        }
    }

}

