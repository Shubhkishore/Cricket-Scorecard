package Team;

import java.util.ArrayList;
import java.util.List;

import Player.Player;

public class Team {

    private String teamName;
    // private String teamCaptain;
    // private String teamCoach;
    // private String teamHomeGround;

    List<Player> players;



    public Team(String teamName) {
        this.teamName = teamName;
    }


    public String getTeamName() {
        return teamName;
    }
}
