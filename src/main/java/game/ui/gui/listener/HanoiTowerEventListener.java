package game.ui.gui.listener;

import com.martialdev.game.hanoitower.core.control.event.HanoiTowerListener;
import com.martialdev.game.hanoitower.core.control.event.PinEvent;
import com.martialdev.game.hanoitower.core.control.event.GameOverEvent;
import com.martialdev.game.hanoitower.core.control.event.GameStartEvent;
import game.ui.gui.PainelDePinosGui;
import game.ui.gui.TorreDeHanoi;

public class HanoiTowerEventListener implements HanoiTowerListener {

    private TorreDeHanoi _torreDeHanoiGUI;
    private PainelDePinosGui _painelDePinoGUI;

    public HanoiTowerEventListener(TorreDeHanoi janela, PainelDePinosGui painelDePinos) {

        this._torreDeHanoiGUI = janela;
        this._painelDePinoGUI = painelDePinos;
    }

    public void fireDiskAdded(PinEvent event) {

        this._painelDePinoGUI.atualizarDisco(event.diskMoved, event.currentMoves);
        this._painelDePinoGUI.atualizarPinos(event.pinPosition, event.targetPin);
    }

    public void hanoiTowerEvent(GameOverEvent event) {

        _painelDePinoGUI.terminarJogo(event.totalMoves, event.score);
    }

    public void fireDiskRemoved(PinEvent event) {

        _painelDePinoGUI.atualizarDisco(event.diskMoved, event.currentMoves);
        _painelDePinoGUI.atualizarPinos(event.pinPosition, event.targetPin);
    }

    public void hanoiTowerEvent(GameStartEvent event) {

        _painelDePinoGUI.iniciarJogo(event.capacity);
    }
}
