/*
 * Criado em 26/09/2005
 *
 * Para alterar o gabarito para este arquivo gerado vá para
 * Janela&gt;Preferências&gt;Java&gt;Geração de Códigos&gt;Código e Comentários
 */
package martes.lairjunior.usjt.algesd.hanoi.command;

import martes.lairjunior.usjt.algesd.hanoi.Disco;
import martes.lairjunior.usjt.algesd.hanoi.Pino;
import martes.lairjunior.usjt.algesd.hanoi.exception.MovimentoInvalidoException;

/**
 * @author alunos
 *
 * Para alterar o gabarito para este comentário do tipo gerado vá para
 * Janela&gt;Preferências&gt;Java&gt;Geração de Códigos&gt;Código e Comentários
 */
public class RemoverPinoCommand implements PinoCommand {
	public Disco doAction(Pino pino, Disco disco) throws MovimentoInvalidoException {
		Disco result = pino.removerDisco();
		// nao contar remocao GerenciadorDoJogo.getInstance().incrementarMovimentos();
		return result;
	}
}
