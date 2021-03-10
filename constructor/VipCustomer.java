package constructor;

public class VipCustomer {


    private String name;
    private Double credit_limit;
    private String email;


    public static void main(String args[]){

        VipCustomer vip = new VipCustomer("Gans",20.6,"gans@gmail.com");

        System.out.print(vip.getEmail());


    }

    private VipCustomer(){
        this("Unknown",0.0,"default@gmail.com");

    }


    public VipCustomer(String name, Double credit_limit) {

        this("",0.0,"default@gmail.com");
    }


    public VipCustomer(String name, Double credit_limit, String email) {
        this.name = name;
        this.credit_limit = credit_limit;
        setEmail(email);

    }


    public String getName() {
        return name;
    }

    public Double getCredit_limit() {
        return credit_limit;
    }

    public String getEmail() {
        return email;
    }

    public  void setEmail(String email){
        this.email = email;
    }


}
