/*
 * Criado em 16/08/2005
 */
package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.pilha.GenericStack;

/**
 * @author Lair Martes Junior RA 200105514
 */
public class DiskStack implements GenericStack<Disk, Disk> {

	private int capacity;
	private int iPos;
	private Disk[] stack;

	public DiskStack(int capacity) {
		reset(capacity);
	}
	public void reset(int capacity) {
		this.capacity = capacity;
		stack = new Disk[capacity];
		fullFilStackWithZeroDisks();
		iPos = 0;
	}
	private void fullFilStackWithZeroDisks() {
		for (int i=0; i<capacity; i++)
			stack[i] = Disk.DISK_ZERO;
	}

	public Disk push(Disk cC) {
		if (iPos >= capacity) return Disk.DISK_ZERO;
		return stack[iPos++] = cC;
	}
	public Disk pop() {
		if (iPos == 0) return Disk.DISK_ZERO;
        Disk result = stack[--iPos];
		stack[iPos] = Disk.DISK_ZERO;
		return result;
	}

	public int size() {
		return iPos;
	}
	public Disk top() {
		return stack[iPos - 1];
	}
	public Disk[] content() {
		return stack;
	}
}
