package martes.lairjunior.usjt.algesd.hanoi.event;

import martes.lairjunior.usjt.algesd.hanoi.HanoiTowerControl;
import martes.lairjunior.usjt.algesd.hanoi.Pin;

public class GameStartEvent {

    private int _definedPinCapacity;

    private Pin[] _currentGamePins;

    public GameStartEvent(int pinCapacity, Pin[] currentPins) {
        this._definedPinCapacity = pinCapacity;
        this._currentGamePins = currentPins;
    }

    public int getPinCapacityDefined() {
        return this._definedPinCapacity;
    }

    public Pin getCurrentPin(HanoiTowerControl.PinPosition pinPosition) {

       return _currentGamePins[pinPosition.ordinal()];

    }
}
