/*
 * Created on 27/09/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package martes.lairjunior.usjt.algesd.hanoi.command;

import martes.lairjunior.usjt.algesd.hanoi.Disk;

/**
 * @author Lair Martes Junior (em casa) Data e hora : 27/09/2005 02:08:00
 *
 */
public class PinoCommandFactory {
	private PinoCommand _adicionarDiscoCommnand;
	private PinoCommand _removerDiscoCommand;
	private static PinoCommandFactory _instance;
	private PinoCommandFactory() {
		_adicionarDiscoCommnand = new AdicionarPinoCommand();
		_removerDiscoCommand = new RemoverPinoCommand();
	}
	public static PinoCommandFactory getInstance() {
		if (_instance == null) {
			_instance = new PinoCommandFactory();
		}
		return _instance;
	}
	public PinoCommand create(Disk disco) {
		if (disco.equals(Disk.DISK_ZERO)) return _removerDiscoCommand;
		else  return _adicionarDiscoCommnand;
	}
}
