package Polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Bike {

    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Bike(String name, int cylinders) {
        this.name = name;
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 2;
    }

    public void  startengine(){
        System.out.println("Engine started");
    }

    public void  acclerate(){
        System.out.println("accelerating");
    }

    public Object  putbreak(){
        return "Break";
    }

    public String getName() {
        return name;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }
}

class tesla extends  Bike{

    private Boolean ev;

    tesla(){
        super("tesla",4);
    }

    public String  putbreak(){
        return "tesla Break";
    }


}

class nikola extends  Bike{

    private Boolean ev;

    nikola(){
        super("tesla",4);
    }

    @Override
    public String putbreak() {
        return "Nikola Break";
    }
}

class ather extends  Bike{

    private Boolean ev;

    ather(){
        super("tesla",4);
    }


    public String  putbreak(){
        return "ather Break";
    }

}

class  Main{
    public  static void main(String[] args){

        Bike a = new ather();
        Bike b = new tesla();
        Bike c = new nikola();
//        a.putbreak();
//        b.putbreak();
//        c.putbreak();
        System.out.println(a.putbreak());
        System.out.println(b.putbreak());
        System.out.println(c.putbreak());

        ArrayList<Integer> test = new ArrayList<>();
        List<Integer> y = (List) test;
        y.add(1);

    }
}



