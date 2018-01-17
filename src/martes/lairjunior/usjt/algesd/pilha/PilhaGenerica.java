/*
 * Criado em 20/08/2005
 */
package martes.lairjunior.usjt.algesd.pilha;

/**
 * @author Lair Martes Junior RA 200105514
 */
public interface PilhaGenerica {
	Object pop();
	Object push(Object cC);
	int size();
	Object top();
	void iniciarPilha(int quantidade);
	Object[] conteudo();
}
