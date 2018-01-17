/*
 * Criado em 16/08/2005
 */
package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.pilha.PilhaGenerica;

;

/**
 * @author Lair Martes Junior RA 200105514
 */
public class PilhaDeDiscos implements PilhaGenerica {

	private int iTam;
	private int iPos;
	private Object[] cPilha;

	public PilhaDeDiscos(int quantidade) {
		iniciarPilha(quantidade);
	}
	public void iniciarPilha(int quantidade) {
		iTam = quantidade;
		cPilha = new Object[iTam];
		preencherPilhaComDiscosZero();
		iPos = 0;
	}
	private void preencherPilhaComDiscosZero() {
		for (int i=0; i<iTam; i++)
			cPilha[i] = Disco.DISCO_ZERO;
	}
	public Object push(Object cC) {
		if (iPos >= iTam) return Disco.DISCO_ZERO;
		return cPilha[iPos++] = cC;
	}
	public Object pop() {
		if (iPos == 0) return Disco.DISCO_ZERO;
        Object result = cPilha[--iPos];
		cPilha[iPos] = Disco.DISCO_ZERO;
		return result;
	}
	public int size() {
		return iPos;
	}
	public Object top() {
		return cPilha[iPos - 1];
	}
	public Object[] conteudo() {
		return cPilha;
	}
}
