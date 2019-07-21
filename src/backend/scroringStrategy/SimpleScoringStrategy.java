package backend.scroringStrategy;

import java.util.ArrayList;

public class SimpleScoringStrategy implements ScoringStrategy {
    @Override
    public int computeScore(ArrayList<Integer> scores) {
        int bonus = 0;
        Integer[] score = scores.toArray(new Integer[0]);
        int totalScore = getTotal(score);

        if (score[0] == 10) {
            bonus = 10;
            System.out.print("A strike !! ");
        } else if (totalScore == 10) {
            bonus = 5;
            System.out.print("A spare !! ");
        }

        totalScore += bonus;
        return totalScore;
    }

    private int getTotal(Integer[] scores) {
        int total = 0;
        for (Integer score : scores) {
            total += score;
        }
        return total;
    }
}
