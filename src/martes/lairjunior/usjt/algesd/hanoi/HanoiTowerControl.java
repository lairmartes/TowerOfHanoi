/*
 * Criado em 26/09/2005
 *
 * Para alterar o gabarito para este arquivo gerado v� para
 * Janela&gt;Prefer�ncias&gt;Java&gt;Gera��o de C�digos&gt;C�digo e Coment�rios
 */
package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.hanoi.exception.InvalidMoveException;

/**
 * @author alunos
 * <p>
 * Para alterar o gabarito para este coment�rio do tipo gerado v� para
 * Janela&gt;Prefer�ncias&gt;Java&gt;Gera��o de C�digos&gt;C�digo e Coment�rios
 */
public class HanoiTowerControl {
    private static HanoiTowerControl _instance;
    private int _movesDone;
    public static final int PIN_1 = 0;
    public static final int PIN_2 = 1;
    public static final int PIN_3 = 2;
    private static final int PINS_AVAILABLE = 3;
    public static final int INITIAL_DISK_CAPACITY = 3;
    private Pin[] _gamePins;
    private Disk _currentDisk;
    private int _pinCapacity;
    private Disk[] _disksInTheGame;
    private double _score;
    private int _minimumMovesRequired;

    public enum PinSequence {
        FIRST, SECOND, THIRD
    }

    public HanoiTowerControl() {

        _pinCapacity = 0;
        _gamePins = new Pin[PINS_AVAILABLE];
        _currentDisk = Disk.DISK_ZERO;
        _disksInTheGame = new Disk[0];
    }

    public static HanoiTowerControl getInstance() {
        if (_instance == null) {
            _instance = new HanoiTowerControl();
            _instance._gamePins = new Pin[PINS_AVAILABLE];
            for (int i = 0; i < PINS_AVAILABLE; i++) {
                _instance._gamePins[i] = new Pin(INITIAL_DISK_CAPACITY);
            }
            _instance.iniciarJogo();
        }
        return _instance;
    }

    public void setDiscoAtual(Disk disco) {
        _currentDisk = disco;
    }

    public Disk getDiscoAtual() {
        return _currentDisk;
    }

    public void incrementarMovimentos() {
        _movesDone++;

    }

    public void iniciarJogo() {
        _currentDisk = new Disk(0);
        _movesDone = 0;
        iniciarDiscos();
        iniciarPinos();
    }

    private void iniciarDiscos() {
        _disksInTheGame = new Disk[_pinCapacity];
        for (int i = 0; i < _pinCapacity; i++) {
            _disksInTheGame[i] = new Disk(i + 1);
        }
    }

    private void iniciarPinos() {
        for (int i = 0; i < PINS_AVAILABLE; i++) {
            _gamePins[i].reset(this._pinCapacity);
        }
        iniciarPrimeiroPino();
    }

    private void iniciarPrimeiroPino() {
        try {
            for (int i = _pinCapacity - 1; i >= 0; i--)
                _gamePins[PIN_1].add(_disksInTheGame[i]);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
    }

    public Pin getPino(int numeroDoPino) {
        return _gamePins[numeroDoPino];
    }

    public int getQuantidadeDeDiscos() {
        return _pinCapacity;
    }

    public void setQuantidadeDeDiscos(int quantidade) {
        _pinCapacity = quantidade;
    }

    public int getQuantidadeDeMovimentos() {
        return _movesDone;
    }

    public boolean isJogoTerminado() {
        int quantidadeDeDiscosDoPino1 = 0;
        Object[] relacaoDiscosPino1 = getPino(PIN_1).getDisks();
        for (int i = 0; i < relacaoDiscosPino1.length; i++) {
            if (!relacaoDiscosPino1[i].equals(Disk.DISK_ZERO))
                quantidadeDeDiscosDoPino1++;
        }
        if (quantidadeDeDiscosDoPino1 > 0) return false;

        int quantidadeDeDiscosDoPino3 = _pinCapacity;
        Object[] relacaoDiscosPino3 = getPino(PIN_3).getDisks();
        for (int i = 0; i < relacaoDiscosPino3.length; i++) {
            if (!relacaoDiscosPino3[i].equals(Disk.DISK_ZERO))
                quantidadeDeDiscosDoPino3--;
        }
        if (quantidadeDeDiscosDoPino3 > 0) return false;
        return true;
    }

    public void startGame(int pinCapacity) {
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
                _gamePins[PIN_1].add(_disksInTheGame[i]);
        } catch (InvalidMoveException e) {
            throw new RuntimeException("No exception were expected here.  Something goes wrong and requires immediate action.");
        }

        //start score and moves
        _movesDone = 0;
        _score = 0.0d;
        _minimumMovesRequired = 2^_pinCapacity - 1;
    }

    public Disk selectFromPin(PinSequence selectedPin) throws InvalidMoveException {
        Pin pinSelected = _gamePins[selectedPin.ordinal()];
        _currentDisk = pinSelected.removeDisk();
        return _currentDisk;
    }

    public void moveSelectedToPin(PinSequence targetPin) throws InvalidMoveException {
        Pin pinSelected = _gamePins[targetPin.ordinal()];
        pinSelected.add(_currentDisk);
        _movesDone++;

        // calculating rating
        if (_movesDone >= _minimumMovesRequired) {
            _score = (double)_minimumMovesRequired / (double)_movesDone;
        }
    }

    protected Disk[] clonePinStack(PinSequence aPin) {
        return _gamePins[aPin.ordinal()].getDisks();
    }

    protected boolean isGameOver() {
        return isJogoTerminado();
    }

    protected double getScore() {
        return _score;
    }

    protected int getMinimumMovesRequired() {
        return _minimumMovesRequired;
    }
}