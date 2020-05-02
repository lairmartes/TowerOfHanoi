package game.ui.command;

import com.martialdev.game.hanoitower.core.control.HanoiTowerControl;
import com.martialdev.game.hanoitower.core.control.exception.InvalidMoveException;

public class AdicionarDiscoNoPino implements JogoCommand {

    private final HanoiTowerControl controladorDaTorre;
    private HanoiTowerControl.PinPosition pinPosition;

    public AdicionarDiscoNoPino(HanoiTowerControl controladorDaTorre) {
        this.controladorDaTorre = controladorDaTorre;
    }

    public void setPinPosition(HanoiTowerControl.PinPosition pinPosition) {
        this.pinPosition = pinPosition;
    }

    public void execute() throws InvalidMoveException {
        controladorDaTorre.grabDisk(pinPosition);
    }
}
