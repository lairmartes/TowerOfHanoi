/*
 * Criado em 20/08/2005
 */
package martes.lairjunior.usjt.algesd.pilha;

/**
 * @author Lair Martes Junior RA 200105514
 */
public interface GenericStack<T, E> {
	T pop();
	T push(E cC);
	int size();
	void reset(int capacity);
	T top();
	T[] content();
}
