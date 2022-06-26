package Scorecard;

import Player.PlayerStats;
import Team.Team;
import Team.TeamStats;

import java.util.List;

public class Scorecard {

//    private String format;
    private int numOfPlayers;
    private int numOfOvers;

    private TeamStats team1;
    private TeamStats team2;
    private TeamStats battingTeam;
    private int balls;
    private int oversCompleted;


    public Scorecard(String format, int numOfPlayers, int numOfOvers) {
//        this.format = format;
        this.numOfPlayers = numOfPlayers;
        this.numOfOvers = numOfOvers;

        team1 = team2 = null;
    }

    // util func
    public void onBoardTeam(Team team, List<PlayerStats> battingOrder){
        if(team1 == null) {
            team1 = new TeamStats(team, numOfOvers, battingOrder);
            battingTeam = team1;
        }
        else {
            team2 = new TeamStats(team, numOfOvers, battingOrder);
            battingTeam = team2;
        }
    }

    public void updateScorecard(String run){
        Outcome outcome = Outcome.getOutcome(run);
//        System.out.println("run "+run+ " outcome "+outcome);
        battingTeam.updateScore(outcome);
    }

    public void displayScorecard(){
        System.out.println();
        System.out.println("Scorecard for Team: " + battingTeam.getTeamName());
        System.out.println("Player Name\t\tScore\t\t4s\t\t6s\t\tBalls");

        for(PlayerStats playerStats: battingTeam.getBattingOrder()){
            String name = playerStats.getPlayerName() + (battingTeam.isOnFieldPlayer(playerStats)?"*":"");
            System.out.format("%10s%10d%10d%10d%10d\n", name, playerStats.getRuns(), playerStats.getFours(), playerStats.getSixes(), playerStats.getBalls());
        }
        System.out.println("Total: " + battingTeam.getScore() +"/" + battingTeam.getWicketsFallen());
        System.out.println(battingTeam.getOversCompleted());
        System.out.println();
    }

    public void getResult() {
        int x = Integer.valueOf(team1.getScore()) - Integer.valueOf(team2.getScore());
        if(x > 0){
            System.out.println("Result: " + team1.getTeamName() +  " won the match by " + x +" runs ");
        }
        else if(x < 0){
            System.out.println("Result: " + team2.getTeamName() +  " won the match by " + (numOfPlayers - 1 - team2.getWicketsFallen()) +" wickets ");
        }
        else{
            System.out.println("Match Drawn");
        }
    }
}
