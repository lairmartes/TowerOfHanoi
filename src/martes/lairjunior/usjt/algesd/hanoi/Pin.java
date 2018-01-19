/*
 * Criado em 26/09/2005
 *
 * Para alterar o gabarito para este arquivo gerado v� para
 * Janela&gt;Prefer�ncias&gt;Java&gt;Gera��o de C�digos&gt;C�digo e Coment�rios
 */
package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.hanoi.exception.InvalidMoveException;
import martes.lairjunior.usjt.algesd.pilha.GenericStack;

/**
 * @author Lair Martes Junior - 2CCPN - USJT
 *
 */
public class Pin {
	private GenericStack _pilhaDeDiscos;
	public Pin() {
		_pilhaDeDiscos = new DiskStack(GerenciadorDoJogo.getInstance().getQuantidadeDeDiscos());
	}
	public void adicionar(Disk discoParaEmpilhar) throws InvalidMoveException {
		if (discoParaEmpilhar == Disk.DISK_ZERO)
			throw new InvalidMoveException("N�o � poss�vel incluir Disk Zero");
		if (_pilhaDeDiscos.size() == 0) {
			_pilhaDeDiscos.push(discoParaEmpilhar);
			return;
		}
		if (getDiscoMaisAlto().compareTo(discoParaEmpilhar) < 1) {
			throw new InvalidMoveException("Pin n�o pode receber " + discoParaEmpilhar);
		}
		else  _pilhaDeDiscos.push(discoParaEmpilhar);
	}
	public Disk removerDisco() throws InvalidMoveException {
		if (_pilhaDeDiscos.size() == 0) {
			throw new InvalidMoveException("O pino n�o tem discos");
		}
		else {
			return (Disk)_pilhaDeDiscos.pop();
		}
	}
	public Object[] getDiscos() {
		return _pilhaDeDiscos.content();
	}
	public void iniciarPilhaDeDiscos() {
		_pilhaDeDiscos.reset(GerenciadorDoJogo.getInstance().getQuantidadeDeDiscos());
	}
	public void iniciarPilhaDeDiscos(int quantidade) {
		_pilhaDeDiscos.reset(quantidade);
	}
	private Disk getDiscoMaisAlto() {
		return (Disk)_pilhaDeDiscos.top();
	}
}
