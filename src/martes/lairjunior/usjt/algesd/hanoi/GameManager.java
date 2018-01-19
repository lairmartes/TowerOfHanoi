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
public class GameManager {
    private static GameManager _instance;
    private int _movesDone;
    public static final int PIN_1 = 0;
    public static final int PIN_2 = 1;
    public static final int PIN_3 = 2;
    private static final int PINS_AVAILABLE = 3;
    public static final int INITIAL_DISK_CAPACITY = 3;
    private Pin[] _gamePins;
    private Disk _currentDisk;
    private int _diskCapacity = INITIAL_DISK_CAPACITY;
    private Disk[] _disksInTheGame = new Disk[_diskCapacity];

    public enum PinSequence {
        FIRST, SECOND, THIRD
    }

    private GameManager() {

    }

    public static GameManager getInstance() {
        if (_instance == null) {
            _instance = new GameManager();
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
        _disksInTheGame = new Disk[_diskCapacity];
        for (int i = 0; i < _diskCapacity; i++) {
            _disksInTheGame[i] = new Disk(i + 1);
        }
    }

    private void iniciarPinos() {
        for (int i = 0; i < PINS_AVAILABLE; i++) {
            _gamePins[i].reset(this._diskCapacity);
        }
        iniciarPrimeiroPino();
    }

    private void iniciarPrimeiroPino() {
        try {
            for (int i = _diskCapacity - 1; i >= 0; i--)
                _gamePins[PIN_1].add(_disksInTheGame[i]);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
    }

    public Pin getPino(int numeroDoPino) {
        return _gamePins[numeroDoPino];
    }

    public int getQuantidadeDeDiscos() {
        return _diskCapacity;
    }

    public void setQuantidadeDeDiscos(int quantidade) {
        _diskCapacity = quantidade;
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

        int quantidadeDeDiscosDoPino3 = _diskCapacity;
        Object[] relacaoDiscosPino3 = getPino(PIN_3).getDisks();
        for (int i = 0; i < relacaoDiscosPino3.length; i++) {
            if (!relacaoDiscosPino3[i].equals(Disk.DISK_ZERO))
                quantidadeDeDiscosDoPino3--;
        }
        if (quantidadeDeDiscosDoPino3 > 0) return false;
        return true;
    }

    public Disk selectFromPin(PinSequence selectedPin) {
        return null;
    }

    public void moveSelectedToPin(PinSequence targetPin) throws InvalidMoveException {

    }

    public Disk[] clonePinStack(PinSequence aPin) {
        return null;
    }
}