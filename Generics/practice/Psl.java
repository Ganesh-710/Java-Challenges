package Generics.practice;

public class Psl extends league{

    public Psl(String name, int prizeMoney) {
        super(name, prizeMoney);
    }

    @Override
    protected void addTeam(Team t) {
        super.addTeam(t);
    }
}
