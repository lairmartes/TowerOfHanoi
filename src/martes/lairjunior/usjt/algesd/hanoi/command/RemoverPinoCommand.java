/*
 * Criado em 26/09/2005
 *
 * Para alterar o gabarito para este arquivo gerado v� para
 * Janela&gt;Prefer�ncias&gt;Java&gt;Gera��o de C�digos&gt;C�digo e Coment�rios
 */
package martes.lairjunior.usjt.algesd.hanoi.command;

import martes.lairjunior.usjt.algesd.hanoi.Disk;
import martes.lairjunior.usjt.algesd.hanoi.Pin;
import martes.lairjunior.usjt.algesd.hanoi.exception.InvalidMoveException;

/**
 * @author alunos
 *
 * Para alterar o gabarito para este coment�rio do tipo gerado v� para
 * Janela&gt;Prefer�ncias&gt;Java&gt;Gera��o de C�digos&gt;C�digo e Coment�rios
 */
public class RemoverPinoCommand implements PinoCommand {
	public Disk doAction(Pin pino, Disk disco) throws InvalidMoveException {
		Disk result = pino.removerDisco();
		// nao contar remocao GerenciadorDoJogo.getInstance().incrementarMovimentos();
		return result;
	}
}
