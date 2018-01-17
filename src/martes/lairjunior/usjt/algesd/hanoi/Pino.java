/*
 * Criado em 26/09/2005
 *
 * Para alterar o gabarito para este arquivo gerado vá para
 * Janela&gt;Preferências&gt;Java&gt;Geração de Códigos&gt;Código e Comentários
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
			throw new MovimentoInvalidoException("Não é possível incluir Disco Zero");
		if (_pilhaDeDiscos.size() == 0) {
			_pilhaDeDiscos.push(discoParaEmpilhar);
			return;
		}
		if (getDiscoMaisAlto().compareTo(discoParaEmpilhar) < 1) {
			throw new MovimentoInvalidoException("Pino não pode receber " + discoParaEmpilhar);
		}
		else  _pilhaDeDiscos.push(discoParaEmpilhar);
	}
	public Disco removerDisco() throws MovimentoInvalidoException {
		if (_pilhaDeDiscos.size() == 0) {
			throw new MovimentoInvalidoException("O pino não tem discos");
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
