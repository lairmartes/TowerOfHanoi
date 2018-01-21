package martes.lairjunior.usjt.algesd.hanoi.gui.listener;

import martes.lairjunior.usjt.algesd.hanoi.event.*;
import martes.lairjunior.usjt.algesd.hanoi.gui.PainelDePinosGui;
import martes.lairjunior.usjt.algesd.hanoi.gui.TorreDeHanoi;

public class HanoiTowerEventListener implements HanoiTowerListener {

    private TorreDeHanoi _torreDeHanoiGUI;
    private PainelDePinosGui _painelDePinoGUI;

    public HanoiTowerEventListener(TorreDeHanoi janela, PainelDePinosGui painelDePinos) {

        this._torreDeHanoiGUI = janela;
        this._painelDePinoGUI = painelDePinos;
    }

    @Override
    public void fireDiskAdded(PinEvent event) {

        this._painelDePinoGUI.atualizarDisco(event.getDiskMoved(), event.getCurrentMoves());
        this._painelDePinoGUI.atualizarPinos(event.getPinPosition(), event.getTargetPin());
    }

    @Override
    public void hanoiTowerEvent(GameOverEvent event) {

        _painelDePinoGUI.terminarJogo(event.getMoveQuantity());

    }

    @Override
    public void fireDiskRemoved(PinEvent event) {

        _painelDePinoGUI.atualizarDisco(event.getDiskMoved(), event.getCurrentMoves());
        _painelDePinoGUI.atualizarPinos(event.getPinPosition(), event.getTargetPin());

    }

    @Override
    public void hanoiTowerEvent(GameStartEvent event) {

        _painelDePinoGUI.iniciarJogo(event.getPinCapacityDefined());
    }
}
