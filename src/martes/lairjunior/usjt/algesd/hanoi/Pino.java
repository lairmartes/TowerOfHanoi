/*
 * Criado em 26/09/2005
 *
 * Para alterar o gabarito para este arquivo gerado v� para
 * Janela&gt;Prefer�ncias&gt;Java&gt;Gera��o de C�digos&gt;C�digo e Coment�rios
 */
package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.hanoi.exception.MovimentoInvalidoException;
import martes.lairjunior.usjt.algesd.pilha.PilhaGenerica;

/**
 * @author Lair Martes Junior - 2CCPN - USJT
 *
 */
public class Pino {
	private PilhaGenerica _pilhaDeDiscos;
	public Pino() {
		_pilhaDeDiscos = new PilhaDeDiscos(GerenciadorDoJogo.getInstance().getQuantidadeDeDiscos());
	}
	public void adicionar(Disco discoParaEmpilhar) throws MovimentoInvalidoException {
		if (discoParaEmpilhar == Disco.DISCO_ZERO)
			throw new MovimentoInvalidoException("N�o � poss�vel incluir Disco Zero");
		if (_pilhaDeDiscos.size() == 0) {
			_pilhaDeDiscos.push(discoParaEmpilhar);
			return;
		}
		if (getDiscoMaisAlto().compareTo(discoParaEmpilhar) < 1) {
			throw new MovimentoInvalidoException("Pino n�o pode receber " + discoParaEmpilhar);
		}
		else  _pilhaDeDiscos.push(discoParaEmpilhar);
	}
	public Disco removerDisco() throws MovimentoInvalidoException {
		if (_pilhaDeDiscos.size() == 0) {
			throw new MovimentoInvalidoException("O pino n�o tem discos");
		}
		else {
			return (Disco)_pilhaDeDiscos.pop();
		}
	}
	public Object[] getDiscos() {
		return _pilhaDeDiscos.conteudo();
	}
	public void iniciarPilhaDeDiscos() {
		_pilhaDeDiscos.iniciarPilha(GerenciadorDoJogo.getInstance().getQuantidadeDeDiscos());
	}
	public void iniciarPilhaDeDiscos(int quantidade) {
		_pilhaDeDiscos.iniciarPilha(quantidade);
	}
	private Disco getDiscoMaisAlto() {
		return (Disco)_pilhaDeDiscos.top();
	}
}
