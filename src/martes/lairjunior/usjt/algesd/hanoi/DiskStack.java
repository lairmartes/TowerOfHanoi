/*
 * Criado em 16/08/2005
 */
package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.pilha.GenericStack;

/**
 * @author Lair Martes Junior RA 200105514
 */
public class DiskStack implements GenericStack<Disk, Disk> {

	private int _capacity;
	private int iPos;
	private Disk[] _stack;

	public DiskStack(int initialCapacity) {
		reset(initialCapacity);
	}
	public void reset(int newCapacity) {
		_capacity = newCapacity;
		_stack = new Disk[_capacity];
		fullFilStackWithZeroDisks();
		iPos = 0;
	}
	private void fullFilStackWithZeroDisks() {
		for (int i = 0; i< _capacity; i++)
			_stack[i] = Disk.DISK_ZERO;
	}

	public Disk push(Disk cC) {
		if (iPos >= _capacity) return Disk.DISK_ZERO;
		return _stack[iPos++] = cC;
	}
	public Disk pop() {
		if (iPos == 0) return Disk.DISK_ZERO;
        Disk result = _stack[--iPos];
		_stack[iPos] = Disk.DISK_ZERO;
		return result;
	}

	protected int size() {
		return iPos;
	}
	public Disk top() {
		return _stack[iPos - 1];
	}
	public Disk[] content() {
		return _stack;
	}
}
