package Player;

public class PlayerStats {

    Player player;
    int runs;
    int fours;
    int sixes;
    int balls;

//    int wickets;

    public PlayerStats(Player player) {
        this.player = player;
    }

    public void updateStats(int run){
        // if player gets out
        if(run == -1){
            this.balls++;
            return;
        }

        this.runs += run;
        balls++;
        if(run == 4)
            this.fours++;
        else if(run == 6)
            this.sixes++;

    }

    @Override
    public String toString() {
        return "PlayerStats{" +
                "player=" + player +
                ", runs=" + runs +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", balls=" + balls +
                '}';
    }

    public String getPlayerName(){
        return player.getName();
    }

    public int getRuns() {
        return runs;
    }

    public int getFours() {
        return fours;
    }

    public int getSixes() {
        return sixes;
    }

    public int getBalls() {
        return balls;
    }
}
