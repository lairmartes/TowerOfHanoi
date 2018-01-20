package martes.lairjunior.usjt.algesd.hanoi.event;

import martes.lairjunior.usjt.algesd.hanoi.Disk;
import martes.lairjunior.usjt.algesd.hanoi.HanoiTowerControl;
import martes.lairjunior.usjt.algesd.hanoi.Pin;

public class PinEvent {

    private Disk _diskMoved;
    private Pin _targetPin;
    private int _currentMoves;
    private Pin[] _currentGamePins;

    public PinEvent(Disk diskMoved, Pin targetPin, int currentMoves, Pin[] gamePins) {
        this._diskMoved = diskMoved;
        this._targetPin = targetPin;
        this._currentMoves = currentMoves;
        this._currentGamePins = gamePins;
    }

    public Disk getDiskMoved() {
        return this._diskMoved;
    }

    public Pin getTargetPin() {
        return this._targetPin;
    }

    public int getCurrentMoves() {
        return this._currentMoves;
    }

    public Pin getCurrentPin(HanoiTowerControl.PinSequence pinSequence) {
        return this._currentGamePins[pinSequence.ordinal()];
    }
}
