/*
 * Criado em 26/09/2005
 *
 * Para alterar o gabarito para este arquivo gerado v� para
 * Janela&gt;Prefer�ncias&gt;Java&gt;Gera��o de C�digos&gt;C�digo e Coment�rios
 */
package martes.lairjunior.usjt.algesd.hanoi.command;

import martes.lairjunior.usjt.algesd.hanoi.Disk;
import martes.lairjunior.usjt.algesd.hanoi.HanoiTowerControl;
import martes.lairjunior.usjt.algesd.hanoi.exception.InvalidMoveException;

/**
 * @author alunos
 * <p>
 * Para alterar o gabarito para este coment�rio do tipo gerado v� para
 * Janela&gt;Prefer�ncias&gt;Java&gt;Gera��o de C�digos&gt;C�digo e Coment�rios
 */
public class PinoCommand {

    private HanoiTowerControl _hanoiTowerControl;

    public PinoCommand(HanoiTowerControl htc) {
        this._hanoiTowerControl = htc;
    }

    public void doAction(HanoiTowerControl.PinPosition pino, Disk disco)
            throws InvalidMoveException {
		if (Disk.DISK_ZERO.equals(disco)) {
		    this._hanoiTowerControl.selectFromPin(pino);
        } else {
		    this._hanoiTowerControl.moveSelectedToPin(pino);
        }
    }
}
