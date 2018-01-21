/*
 * Criado em 26/09/2005
 *
 * Para alterar o gabarito para este arquivo gerado v� para
 * Janela&gt;Prefer�ncias&gt;Java&gt;Gera��o de C�digos&gt;C�digo e Coment�rios
 */
package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.hanoi.event.*;
import martes.lairjunior.usjt.algesd.hanoi.exception.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alunos
 * <p>
 * Para alterar o gabarito para este coment�rio do tipo gerado v� para
 * Janela&gt;Prefer�ncias&gt;Java&gt;Gera��o de C�digos&gt;C�digo e Coment�rios
 */
public class HanoiTowerControl {

    private int _movesDone;
    private static final int PINS_AVAILABLE = 3;
    private Pin[] _gamePins;
    private Disk _currentDisk;
    private int _pinCapacity;
    private Disk[] _disksInTheGame;
    private double _score;
    private int _minimumMovesRequired;
    private List<HanoiTowerListener> _hanoiTowerListener;

    public enum PinPosition {
        FIRST, SECOND, THIRD
    }

    public HanoiTowerControl() {

        this._pinCapacity = -1;

        _gamePins = new Pin[PINS_AVAILABLE];
        _currentDisk = Disk.DISK_ZERO;
        _disksInTheGame = new Disk[0];

        _hanoiTowerListener = new ArrayList<>();

    }

    public void startGame(int pinCapacity) {
        restartGame(pinCapacity);
    }

    public void restartGame(int pinCapacity) {
        // set disk capacity of the pins
        this._pinCapacity = pinCapacity;

        //initiate pins
        for (int i = 0; i < PINS_AVAILABLE; i++) {
            this._gamePins[i] = new Pin(this._pinCapacity);
        }
        // no disks are selected, then set it to Disk size zero
        _currentDisk = new Disk(0);
        _movesDone = 0; // no moves done yet

        //including disks in the game based on pin capacity
        _disksInTheGame = new Disk[this._pinCapacity];
        // initialize disks with size from 1 to pin capacity
        for (int i = 0; i < this._pinCapacity; i++) {
            _disksInTheGame[i] = new Disk(i + 1);
        }

        // indicate that pins will be able to stack the given pin capacity
        for (int i = 0; i < PINS_AVAILABLE; i++) {
            _gamePins[i].reset(this._pinCapacity);
        }

        // include all disks in the first pin
        try {
            for (int i = this._pinCapacity - 1; i >= 0; i--)
                _gamePins[PinPosition.FIRST.ordinal()].add(_disksInTheGame[i]);
        } catch (InvalidMoveException e) {
            throw new RuntimeException("No exception were expected here.  Something goes wrong and requires immediate action.");
        }

        //start score and moves
        _movesDone = 0;
        _score = 0.0d;
        _minimumMovesRequired = (int) Math.pow(2, _pinCapacity) - 1;

        broadCastEvent(new GameStartEvent(this._pinCapacity, _gamePins.clone()));
    }

    public Disk selectFromPin(PinPosition pinPosition) throws InvalidMoveException {
        Pin pinSelected = _gamePins[pinPosition.ordinal()];
        _currentDisk = pinSelected.removeDisk();

        fireDiskRemoved(new PinEvent(this._currentDisk, pinPosition, pinSelected, this._movesDone));

        return _currentDisk;
    }

    public void moveSelectedToPin(PinPosition pinPosition) throws InvalidMoveException {
        Pin pinSelected = _gamePins[pinPosition.ordinal()];
        pinSelected.add(_currentDisk);
        _movesDone++;

        // calculating rating
        if (_movesDone >= _minimumMovesRequired) {
            _score = (double) _minimumMovesRequired / (double) _movesDone;
        }

        fireDiskAdded(new PinEvent(_currentDisk, pinPosition, pinSelected, this._movesDone));

        if (isGameOver()) {
            broadCastEvent(new GameOverEvent(this._movesDone, this._score));
        }
    }

    /* method created for testing purposes */
    protected int currentStackSize(PinPosition aPin) {
        return _gamePins[aPin.ordinal()].getStackSize();
    }

    private boolean isGameOver() {

        for (Disk d : _gamePins[PinPosition.FIRST.ordinal()].getDisks()) {
            if (!Disk.DISK_ZERO.equals(d)) {
                return false;
            }
        }

        for (Disk d : _gamePins[PinPosition.THIRD.ordinal()].getDisks()) {
            if (Disk.DISK_ZERO.equals(d)) return false;
        }

        return true;
    }


    public void addListener(HanoiTowerListener listener) {
        this._hanoiTowerListener.add(listener);
    }

    //event broadcaster
    private void fireDiskAdded(PinEvent event) {

        for (HanoiTowerListener listener : _hanoiTowerListener) {
            listener.fireDiskAdded(event);
        }
    }

    private void broadCastEvent(GameOverEvent event) {

        for (HanoiTowerListener listener : _hanoiTowerListener) {
            listener.hanoiTowerEvent(event);
        }
    }

    private void fireDiskRemoved(PinEvent event) {

        for (HanoiTowerListener listener : _hanoiTowerListener) {
            listener.fireDiskRemoved(event);
        }
    }

    private void broadCastEvent(GameStartEvent event) {

        for (HanoiTowerListener listener : _hanoiTowerListener) {
            listener.hanoiTowerEvent(event);
        }
    }
}