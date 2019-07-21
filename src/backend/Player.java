package backend;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private int totalPinsLeft;
    private String name;
    private int score;
    private int turnsLeft;
    private Random random = new Random();
    ArrayList<Integer> scoresToEvaluate = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.totalPinsLeft = 10;
        this.turnsLeft = 20;
    }

    void decreaseTurnsLeft() {
        this.turnsLeft--;
    }

    int bowl() {
        int num = random.nextInt(totalPinsLeft + 1);
        totalPinsLeft -= num;
        return num;
    }

    void addScore(int score) {
        this.score += score;
    }

    void resetState() {
        this.totalPinsLeft = 10;
        this.scoresToEvaluate.clear();
    }

    void resetPins() {
        this.totalPinsLeft = 10;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }
}
