import java.util.*;

class Team {
    protected String name;
    protected int matchesPlayed, wins, draws;

    public Team(String name, int matchesPlayed, int wins, int draws) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.draws = draws;
    }

    public int calculatePoints() { return 0; }
}

class CricketTeam extends Team {
    public CricketTeam(String name, int matchesPlayed, int wins, int draws) {
        super(name, matchesPlayed, wins, draws);
    }
    public int calculatePoints() { return wins * 2 + draws; }
}

class FootballTeam extends Team {
    public FootballTeam(String name, int matchesPlayed, int wins, int draws) {
        super(name, matchesPlayed, wins, draws);
    }
    public int calculatePoints() { return wins * 3 + draws; }
}

public class SportsLeague {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            String[] d = sc.nextLine().split(",");
            Team team = d[0].equalsIgnoreCase("Cricket")
                    ? new CricketTeam(d[1], Integer.parseInt(d[2]), Integer.parseInt(d[3]), Integer.parseInt(d[4]))
                    : new FootballTeam(d[1], Integer.parseInt(d[2]), Integer.parseInt(d[3]), Integer.parseInt(d[4]));
            System.out.println("Team: " + team.name + " (" + d[0] + ") Points: " + team.calculatePoints());
        }
        sc.close();
    }
}
