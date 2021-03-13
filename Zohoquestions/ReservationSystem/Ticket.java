package Zohoquestions.ReservationSystem;

public class Ticket implements  Cloneable {

    private final int id;
    public String name;
    private int age;
    private String gender ;
    private boolean status ;
    private String berth;
    private String ticStage;

    public Ticket(int id, String name, int age, String gender, String berth,String ticStage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.status = false;
        this.berth = berth;
        this.ticStage = ticStage;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Name : "+name+" Age : "+age+" gender : "+gender+" berth : "+berth;
    }

    public void setTicStage(String ticStage) {
        this.ticStage = ticStage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBerth() {
        return berth;
    }

    public void setBerth(String berth) {
        this.berth = berth;
    }
}
