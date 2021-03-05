package Generics.practice;

public class GenericsChallenge {

    public static void main(String[] args) {
        league<Ipl> league = new league<>("Ipl",1000);
        Team<Psl> karachi = new Team<>("karachi");

        Team<Ipl> CSK = new Team<>("CSK");
        Team<Ipl> MI = new Team<>("MI");
        Team<Ipl> SRH = new Team<>("SRH");
        Team<Ipl> KxlP = new Team<>("KxlP");
        Team<Ipl> Rcb = new Team<>("Rcb");
        Team<Ipl> RR = new Team<>("RR");
        Team<Ipl> DC = new Team<>("DC");
        Team<Ipl> KKR = new Team<>("KKR");

        CSK.Match(MI,1,2);
        CSK.Match(MI,1,2);
        CSK.Match(DC,3,2);
        CSK.Match(RR,12,2);
        CSK.Match(KKR,112,2);

        league.addTeam(CSK);
        league.addTeam(MI);
        league.addTeam(SRH);
        league.addTeam(KxlP);
        league.addTeam(Rcb);
        league.addTeam(RR);
        league.addTeam(DC);
        league.addTeam(KKR);
//        league.listTeams();

        System.out.println(CSK.getGamesWon());
        System.out.println(MI.getGamesWon());
        league.listsortedteam();
    }

}
