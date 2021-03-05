package Generics.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class name{

}

class ganesh extends name{
    public void ganeshh(){

    }
}

class gans extends name{
    public void ganss(){

    }

}

public class prac {
    static List<Number> list= new ArrayList<>();
    static double sumofnum(List<? super Integer> list){
        double sum=0;
        for(Object num : list){
//            sum += num.doubleValue();
        }
        return sum;


    }

    static <T extends  Number> void  add( T num){
          list.add(num);
    }

    public static void main(String[] args) {

//        List<Integer> f = new ArrayList<>(List.of(1));
//        Number n = 1;
//        add(1);
////        add(1.2d);
////        add(1l);
////        add(1.2f);
//        List<? extends Number> m = new ArrayList<Integer>();
//        Integer a = 1;
//        m.add(a);
//        System.out.println(list.toString());
////     1
        //defining an array of type String
        String[] countries = {"g","a","n","e","s","h","g"};
        int size = countries.length;
//logic for sorting
        for(int i = 0; i<size-1; i++)
        {
            for (int j = i+1; j<countries.length; j++)
            {
//compares each elements of the array to all the remaining elements
                if(countries[i].compareTo(countries[j])>0)
                {
//swapping array elements
                    String temp = countries[i];
                    countries[i] = countries[j];
                    countries[j] = temp;
                }
            }
        }
//prints the sorted array in ascending order
        System.out.println(Arrays.toString(countries));
    }



}


