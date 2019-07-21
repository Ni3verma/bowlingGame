package backend;

import backend.scroringStrategy.ScoringStrategy;

public class SimpleBowlingGame {
    private static final int CHANCE_PER_TURN = 2;

    private ScoringStrategy scoringStrategy;

    public SimpleBowlingGame(ScoringStrategy scoringStrategy) {
        this.scoringStrategy = scoringStrategy;
    }


    public void bowl(Player player) {
        int score = player.bowl();

        player.scoresToEvaluate.add(score);

        if (player.scoresToEvaluate.size() == 1 && score == 10) {
            // a strike in the first try means no second try
            player.decreaseTurnsLeft();
        }

        if (player.scoresToEvaluate.size() == CHANCE_PER_TURN) {
            int totalScore = scoringStrategy.computeScore(player.scoresToEvaluate);

            if (player.getTurnsLeft() == 1 && totalScore > 10) {
                // a spare or strike in the last set means one extra bowl
                player.resetPins();
                int extra = player.bowl();
                player.scoresToEvaluate.add(extra);
                totalScore += extra;
            }

            player.addScore(totalScore);
            printLiveData(player, totalScore);
            player.resetState();
        }

        player.decreaseTurnsLeft();
    }

    private void printLiveData(Player player, int totalScore) {
        System.out.println(player.getName()
                + ": "
                + player.scoresToEvaluate
                + " score added="
                + totalScore
                + ", curr score="
                + player.getScore()
        );
    }

}
