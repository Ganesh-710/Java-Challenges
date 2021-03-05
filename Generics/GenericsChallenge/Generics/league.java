package Generics.GenericsChallenge.Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class league<T extends league> {
    private List<Team> teams;
    private String name;
    private int prizeMoney;

    public league(String name, int prizeMoney) {
        this.teams = new ArrayList<>();
        this.name = name;
        this.prizeMoney = prizeMoney;
    }

    protected  void addTeam(Team<T> t){
        if(!this.teams.contains(t)){
            this.teams.add(t);
        }else{
            System.out.println(t.getName()+" already exists");
        }
    }

    protected void listTeams(){
        int size = this.teams.size();
        for (int i = 0; i < size; i++) {
            System.out.println(this.teams.get(i).getName());
        }
    }



    public  void listsortedteam(){
        int size = this.teams.size();
        Collections.sort(this.teams);
        for (Team t :
             this.teams) {
            System.out.println("Team "+t.getName()+" Points "+t.getGamesWon());
        }
    }


}
