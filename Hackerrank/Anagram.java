package Hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    static String sort(String[] arr){

        int size = arr.length;
        for(int i = 0; i<size-1; i++)
        {
            for (int j = i+1; j<arr.length; j++)
            {
                if(arr[i].compareTo(arr[j])>0)
                {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("arr "+ Arrays.toString(arr));
        return toString(arr);
    }

    static String toString(String[] arr){
        String val = "";
        for(int i =0;i<arr.length;i++){
            val +=arr[i];
        }
        System.out.println("val "+val);

        return val;
    }

    static boolean isAnagram(String a, String b) {
        // Complete the function
        String[] arr1 = a.toLowerCase().split("");
        String[] arr2 = b.toLowerCase().split("");



        if(arr1.length == arr2.length){
            if(sort(arr1).equals(sort(arr2)))                                     {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}


