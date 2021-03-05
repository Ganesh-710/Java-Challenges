package Generics.GenericsChallenge.Generics;

public class Team<T extends league> implements Comparable<Team>    {
    private String name;
    private int gamesPlayed;
    private int gamesWon;
    private  int gamesdrew;

    public Team(String name) {
        this.name = name;
        this.gamesdrew=0;
        this.gamesWon=0;
    }


    public String getName() {
        return name;
    }

    public int getGamesWon(){
        return this.gamesWon;
    }

    public void Match(Team<T> team, int s1,int s2){
        if(s1>s2){
            this.gamesWon++;
        }else if(s1<s2){
            team.gamesWon++;
        }
    }

    @Override
    public int compareTo(Team o) {
        int value = 0;
        if(this.gamesWon > o.gamesWon){
           value = -1;
        }else if(this.gamesWon < o.gamesWon){
            value = 1;
        }
        return value;
    }


}
