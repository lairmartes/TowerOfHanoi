/*
 * Criado em 26/09/2005
 *
 * Para alterar o gabarito para este arquivo gerado vá para
 * Janela&gt;Preferências&gt;Java&gt;Geração de Códigos&gt;Código e Comentários
 */
package martes.lairjunior.usjt.algesd.hanoi;

/**
 * @author Lair Martes Junior - 2CCPN - USJT
 *
 */
public class Disk implements Comparable{
	public final static Disk DISK_ZERO = new Disk(0);
	private int _size;
	private String _toString;
	public Disk(int tamanho) {
		_size = tamanho;
		_toString = "Disk Size " + tamanho;
	}
	public int getSize() {
		return _size;
	}
	public int compareTo(Object o) {
		if (!(o instanceof Disk)) return 0;
		return _size - ((Disk)o).getSize();
	}
	public String toString() {
		return _toString;
	}
	public boolean equals(Object o) {
		if (!(o instanceof Disk))
			return false;
		return ((Disk)o).getSize() == this.getSize();
	}
}