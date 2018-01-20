package martes.lairjunior.usjt.algesd.hanoi.event;

public class GameOverEvent {

    private int _moveQuantity;
    private double _score;

    public GameOverEvent(int moves, double score) {
        this._moveQuantity = moves;
        this._score = score;
    }

    public int getMoveQuantity() {
        return this._moveQuantity;
    }

    public double getScore() {
        return this._score;
    }
}
