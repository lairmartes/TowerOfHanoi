/*
 * Criado em 26/09/2005
 *
 */
package game.ui.command;

import com.martialdev.game.hanoitower.core.control.HanoiTowerControl;
import com.martialdev.game.hanoitower.core.control.exception.InvalidMoveException;
import com.martialdev.game.hanoitower.core.control.Disk;

public class PinoCommand {

    private HanoiTowerControl _hanoiTowerControl;

    public PinoCommand(HanoiTowerControl htc) {
        this._hanoiTowerControl = htc;
    }

    public void doAction(HanoiTowerControl.PinPosition pino, Disk disco)
            throws InvalidMoveException {
		if (Disk.DISK_ZERO.equals(disco)) {
		    this._hanoiTowerControl.grabDisk(pino);
        } else {
		    this._hanoiTowerControl.dropDisk(pino);
        }
    }
}
