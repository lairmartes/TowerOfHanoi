package martes.lairjunior.usjt.algesd.hanoi.event;

import martes.lairjunior.usjt.algesd.hanoi.Disk;
import martes.lairjunior.usjt.algesd.hanoi.Pin;

public class MoveEvent {

    private Disk _diskMoved;
    private Pin _targetPin;
    private int _currentMoves;

    public MoveEvent(Disk diskMoved, Pin sourcePin, Pin targetPin, int currentMoves) {
        this._diskMoved = diskMoved;
        this._targetPin = targetPin;
        this._currentMoves = currentMoves;
    }

    public Disk getDiskMoved() {
        return _diskMoved;
    }

    public Pin getTargetPin() {
        return _targetPin;
    }

    public int getCurrenMoves() {
        return _currentMoves;
    }
}
