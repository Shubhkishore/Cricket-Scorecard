package Team;

import Player.*;
import Scorecard.Outcome;

import java.util.List;

public class TeamStats {

    Team team;
    int overs;
    List<PlayerStats> battingOrder;

    private int score;
    private int wicketsFallen;
    private PlayerStats[] onFieldPlayers;
    private int onStrike;
    private int balls;
    private int oversCompleted;

    public TeamStats(Team team, int overs, List<PlayerStats> battingOrder) {
        this.team = team;
        this.battingOrder = battingOrder;
        this.overs = overs;

        oversCompleted = 0;
        wicketsFallen = 0;
        balls = 0;
        score = 0;
        onFieldPlayers = new PlayerStats[2];
        onFieldPlayers[0] = battingOrder.get(0);
        onFieldPlayers[1] = battingOrder.get(1);
        onStrike = 0;
    }

    public void updateScore(Outcome outcome){
        boolean isExtra = false;
        if(!outcome.equals(Outcome.WIDE) && !outcome.equals(Outcome.NO_BALL))
            balls++;
        else
            isExtra = true;

        int outcomeValue = Outcome.getOutcomeValue(outcome);
        if(outcomeValue>0)
            score += outcomeValue;

        // update player score
        if(!isExtra)
            onFieldPlayers[onStrike].updateStats(outcomeValue);

        if(outcome.equals(Outcome.WICKET)){
//            System.out.println("Player out "+onFieldPlayers[onStrike]);
            wicketsFallen++;
            if(wicketsFallen == battingOrder.size()-1){
//                System.out.println("Team all out");
                onFieldPlayers[onStrike] = null;
                return;
            }
            else
                onFieldPlayers[onStrike] = battingOrder.get(wicketsFallen +1);
//            System.out.println("New player "+onFieldPlayers[onStrike]);
        }

        // change strike
        if(outcome.equals(Outcome.ONE) || outcome.equals(Outcome.THREE)){
            onStrike = 1 - onStrike;
        }

        if(balls % 6 == 0){
            oversCompleted++;
            balls = 0;
            onStrike = 1 - onStrike;
        }

    }

    public boolean isInningsOver(){
        if(oversCompleted == overs || wicketsFallen == battingOrder.size()-1)
            return true;
        return false;
    }

    public String getTeamName(){
        return team.getTeamName();
    }

    public boolean isOnFieldPlayer(PlayerStats ps){
        return ps.equals(onFieldPlayers[0]) || ps.equals(onFieldPlayers[1]);
    }

    public List<PlayerStats> getBattingOrder() {
        return battingOrder;
    }

    public String getScore() {
        return String.valueOf(score);
    }

    public String getOversCompleted() {
        return "Overs: " + String.valueOf(oversCompleted) + (balls>0 ? "."+String.valueOf(balls): "");
    }

    public int getWicketsFallen() {
        return wicketsFallen;
    }
}
