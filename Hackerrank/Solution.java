package Hackerrank;

import java.util.Scanner;

public class Solution {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
            int[] array = {1,-2,4,-5,1};
        int count = 0;
        int sum   = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum < 0) {
                    count++;
                }
            }
            sum = 0;
        }
       System.out.println(count);
        }
    }
//     int n = scan.nextInt();
//     if(n >= 1 && n <= 100){
//         int arr[] = inputarr(n);
//         int cunt = 0;
//         int value = 0;

//         for(int i = 0; i < n-1 ; i++){
//             value = arr[i];
//             for(int j = i; j < n ; j++){
//                if(i == j){
//                    if(arr[i] < 0){
//                        cunt++;
//                    }
//                    continue;
//                }else{
//                        value = value + arr [j];
//                        if(value < 0){
//                            cunt++;
//                    }
//                }
//             }

//         }

//         System.out.println(cunt);
//     }

// }
