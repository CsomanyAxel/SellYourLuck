package at.htlleonding.demo.model;

public class Game {
    private int id;
    private String length;
    private int points;
    private int sells;

    public Game(int id, String length, int points, int sells) {
        this.id = id;
        this.length = length;
        this.points = points;
        this.sells = sells;
    }

    public int getId() {
        return id;
    }

    public String getLength() {
        return length;
    }

    public int getPoints() {
        return points;
    }

    public int getSells() {
        return sells;
    }

    @Override
    public String toString() {
        return String.format("%s: %d points reached with %d sells", length, points, sells);
    }
}
