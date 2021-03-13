package Zohoquestions.ReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {

    public static void main(String[] args) throws CloneNotSupportedException {
        List<Train> trains = new ArrayList<>();

        Train t = new Train(1, "chennai express", 3, 2, 2);
//        Map<String,String> m = new HashMap<>();
//        m.put("name","ganesh");
//        m.put("age","19");
//        m.put("gender","male");
//        m.put("berth","upper");
//        m.put("ticStage","confirmed");
//        t.bookTicket(m);
//        t.bookTicket(m);
//        t.bookTicket(m);
//        Map<String,String> surya = new HashMap<>();
//        m.put("name","surya");
//        m.put("age","19");
//        m.put("gender","male");
//        m.put("berth","lower");
//        m.put("ticStage","rac");
//        t.bookTicket(m);
//        t.printBookedTickets();

        t.printUnoccupiedTickets();

    }

}
