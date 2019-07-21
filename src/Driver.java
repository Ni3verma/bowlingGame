import backend.Player;
import backend.SimpleBowlingGame;
import backend.scroringStrategy.SimpleScoringStrategy;

import java.util.ArrayList;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        SimpleBowlingGame game = new SimpleBowlingGame(new SimpleScoringStrategy());
        simulateGame(game);
    }

    private static void simulateGame(SimpleBowlingGame game) {
        Random random = new Random();

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Nitin"));
        players.add(new Player("Suraj"));

        while (!players.isEmpty()) {
            int index = random.nextInt(players.size());
            Player player = players.get(index);

            game.bowl(player);

            if (player.getTurnsLeft() == 0) {
                players.remove(player);
                System.out.println("\n*********\n" + player.getName() + ":" + player.getScore() + "\n***********\n");
            }
        }
    }

}
