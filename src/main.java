import Player.*;
import Scorecard.Scorecard;
import Team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        System.out.println("No. of players for each team: 5");
//        int numOfPlayers = in.nextInt();
        int numOfPlayers = 5;

        System.out.println("No. of overs: 2");
//        int numOfOvers = in.nextInt();
        int numOfOvers = 2;

        Scorecard scorecard = new Scorecard("t2", 5, 2);

        System.out.println("Batting Order for team 1:");
        List<PlayerStats> order = new ArrayList<PlayerStats>();
        for(int i=0;i<5;i++){
//            String name = in.nextLine();
            Player player = new Player("P"+(i+1));
            PlayerStats ps = new PlayerStats(player);
            order.add(ps);
        }
        Team team = new Team("Team PikaChu");
        scorecard.onBoardTeam(team, order);
        // over 1
        scorecard.updateScorecard("1");
        scorecard.updateScorecard("1");
        scorecard.updateScorecard("1");
        scorecard.updateScorecard("1");
        scorecard.updateScorecard("1");
        scorecard.updateScorecard("2");

        scorecard.displayScorecard();

        //over 2
        scorecard.updateScorecard("W");
        scorecard.updateScorecard("4");
        scorecard.updateScorecard("4");
        scorecard.updateScorecard("Wd");
        scorecard.updateScorecard("W");
        scorecard.updateScorecard("1");
        scorecard.updateScorecard("6");

        scorecard.displayScorecard();

        System.out.println("Batting Order for team 1:");
        List<PlayerStats> order2 = new ArrayList<PlayerStats>();
        for(int i=5;i<10;i++){
//            String name = in.nextLine();
            Player player = new Player("P"+(i+1));
            PlayerStats ps = new PlayerStats(player);
            order2.add(ps);
        }

        Team team2 = new Team("Team Charmander");
        scorecard.onBoardTeam(team2, order2);
        // over 1
        scorecard.updateScorecard("4");
        scorecard.updateScorecard("6");
        scorecard.updateScorecard("W");
        scorecard.updateScorecard("W");
        scorecard.updateScorecard("1");
        scorecard.updateScorecard("1");

        scorecard.displayScorecard();

        //over 2
        scorecard.updateScorecard("6");
        scorecard.updateScorecard("1");
        scorecard.updateScorecard("W");
        scorecard.updateScorecard("6");

        scorecard.displayScorecard();

        scorecard.getResult();

    }
}

