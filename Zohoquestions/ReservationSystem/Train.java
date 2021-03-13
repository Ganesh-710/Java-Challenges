package Zohoquestions.ReservationSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Train {
    static Scanner scan = new Scanner(System.in);
    private final int id;
    private final int MAX_TICKETS;
    private final int MAX_RAC_TICKETS;
    private final int MAX_WAITINGLiIST_TICKETS;
    private List<Ticket> tickets = new ArrayList<>();
    private List<Ticket> underAged = new ArrayList<>();
    private int underAgedCOunt = 0;
    private String name;
    private int availableUpperBerth ;
    private  int availableLowerBerth ;
    private int availableMiddleBerth ;
    private int availableRacTicket;
    private int availablewaitingList;

    public Train( int id, String name, int MAX_TICKETS, int MAX_WAITINGLiIST_TICKETS, int MAX_RAC_TICKETS  ) {

        this.name = name;
        this.id = id;
        this.MAX_TICKETS = MAX_TICKETS;
        this.MAX_WAITINGLiIST_TICKETS= MAX_WAITINGLiIST_TICKETS;
        this.MAX_RAC_TICKETS = MAX_RAC_TICKETS;
        this.availableUpperBerth = MAX_TICKETS / 3;
        this.availableLowerBerth = availableUpperBerth;
        this.availableMiddleBerth = availableUpperBerth;
        this.availableRacTicket = MAX_RAC_TICKETS;
        this.availablewaitingList = MAX_WAITINGLiIST_TICKETS;

        int totalTickets = MAX_TICKETS + MAX_RAC_TICKETS + MAX_WAITINGLiIST_TICKETS ;

        for(int i=1 ; i <= totalTickets ;i++){
            tickets.add(new Ticket(i,null,0,null,null,null));
        }

    }

    public void bookTicket(Map<String,String> newTicket ) throws CloneNotSupportedException {

            int totalAvailableTickets = availableUpperBerth + availableLowerBerth + availableMiddleBerth + availablewaitingList + availableRacTicket;
            int totalReservedTickets = availableUpperBerth + availableLowerBerth + availableMiddleBerth;

        if(totalAvailableTickets >  0 )  {

            if( Integer.parseInt(newTicket.get("age")) <= 5 ){
                underAgedCOunt++;
                System.out.println("Sorry your not eligible for a ticket");
                underAged.add(new Ticket(underAgedCOunt,newTicket.get("name"),Integer.parseInt(newTicket.get("age")),
                        newTicket.get("gender"),newTicket.get("berth"),newTicket.get("ticStage")));
            }else if(Integer.parseInt(newTicket.get("age")) > 60 ){
                if(availableLowerBerth > 0 ){
                    allocateTicket(newTicket,"lower",newTicket.get("ticStage"));
                    availableLowerBerth--;
                }else{
                    System.out.println("Lower birth is full");
                }
            }else if(newTicket.get("ticStage").equals("confirmed")){
                          if(totalReservedTickets > 0 ){
                              if(newTicket.get("berth").equals("upper")){
                                  bookUpperTicket(newTicket, "confirmed");
                              }else if(newTicket.get("berth").equals("Lower")){
                                  bookLowerTicket(newTicket, "confirmed");
                              }else if(newTicket.get("berth").equals("middle")){
                                  bookMiddleTicket(newTicket, "confirmed");
                              }
                          }else {
                              System.out.println("Sorry Reservation tickets are full");
                          }
            } else if(newTicket.get("ticStage").equals("rac")){
                    if(availableRacTicket > 0 ){
                        if(newTicket.get("berth").equals("upper")){
                            bookUpperTicket(newTicket, "rac");
                        }else if(newTicket.get("berth").equals("lower")){
                            bookLowerTicket(newTicket, "rac");
                        }else if(newTicket.get("berth").equals("middle")){
                            bookMiddleTicket(newTicket, "rac");
                        }
                    }else{
                        System.out.println("Sorry RAC tickets are full");
                    }
        }else if (newTicket.get("ticStage").equals("waiting")) {
                if (availablewaitingList > 0) {
                    allocateTicket(newTicket, null, "waiting");
                } else {
                    System.out.println("Sorry tickets are full");
                }
            }

     } else  {
                System.out.println("Sorry reservation is closed");
            }
    }

    private boolean bookUpperTicket(Map<String,String> newTicket, String ticStage){

        boolean returnFlag = false;

        if(availableUpperBerth > 0){
            allocateTicket(newTicket, "upper",ticStage);
            availableUpperBerth--;
            returnFlag =  true;
        }else{
            System.out.println("Sorry upper ticket is filled, press 1 if you want to continue with Lower or 0 to continue with Middle");
            int flag = scan.nextByte();
            if(flag == 1){
                returnFlag =   bookLowerTicket(newTicket,ticStage);
            }else if(flag == 0){
                returnFlag =   bookMiddleTicket(newTicket, ticStage);
            }

        }
        return  returnFlag;
    }

    private boolean bookLowerTicket(Map<String,String> newTicket, String  ticStage){

        boolean returnFlag = false;

        if(availableLowerBerth > 0){
            allocateTicket(newTicket, "lower",ticStage);
            availableLowerBerth--;
            returnFlag =  true;
        }else{
            System.out.println("Sorry Lower ticket is filled, press 1 if you want to continue with Upper or 0 to continue with Middle");
            int flag = scan.nextByte();
            if(flag == 1){
                returnFlag =  bookUpperTicket(newTicket,ticStage);
            }else if(flag == 0){
                returnFlag =   bookMiddleTicket(newTicket,ticStage);
            }
        }

        return returnFlag;
    }

    private boolean bookMiddleTicket(Map<String,String> newTicket, String ticStage){
        boolean returnFlag = false;

        if(availableMiddleBerth > 0){
            allocateTicket(newTicket, "middle",ticStage);
            availableMiddleBerth--;
            returnFlag =  true;
        }else{
            System.out.println("Sorry Middle ticket is filled, press 1 if you want to continue with Upper or 0 to continue with Lwer");
            int flag = scan.nextByte();
            if(flag == 1){
                returnFlag =    bookUpperTicket(newTicket,ticStage);
            }else if(flag == 0){
                returnFlag =  bookLowerTicket(newTicket,ticStage);
            }
        }

        return returnFlag;
    }

    private void allocateTicket(Map<String,String> newTicket,String berth, String ticStage){

        for (Ticket t:
             tickets) {
            if(!t.getStatus()){
                t.setName(newTicket.get("name"));
                t.setAge(Integer.parseInt(newTicket.get("age")));
                t.setBerth(berth);
                t.setGender(newTicket.get("gender"));
                t.setStatus(true);
                t.setTicStage(ticStage);
                break;
            }

            availableRacTicket = (ticStage.equals("rac")) ? availableRacTicket-- : availableRacTicket;
            availablewaitingList = (ticStage.equals("waiting")) ? availablewaitingList-- : availablewaitingList;
        }

    }

    public void printUnoccupiedTickets(){
        int cunt = 0;
        for (Ticket t:
            tickets ) {
            if(!t.getStatus()){
                cunt++;
                 System.out.println(tickets.toString());
                System.out.println();
            }
        }

        System.out.println("Total number iof unoccupied tickets "+cunt);
    }

    public void cancelTicket(Ticket tobeCanceled){
        for (Ticket t:
             tickets) {
            if( t.getAge() == tobeCanceled.getAge() && t.getName().equals(tobeCanceled.getName())){
                t.setName(null);
                t.setAge(0);
                t.setBerth(null);
                t.setGender(null);
                t.setStatus(false);
                t.setTicStage(null);
                break;
            }
        }
    }

    public void printBookedTickets(){
        for (Ticket t:
                tickets) {
            if(t.getStatus()){
                System.out.println(t.toString());
            }
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
