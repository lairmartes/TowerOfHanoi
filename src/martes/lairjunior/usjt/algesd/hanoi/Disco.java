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
public class Disco implements Comparable{
	public final static Disco DISCO_ZERO = new Disco(0);
	private int _tamanho;
	private String _toString;
	private int _hashCode;
	public Disco(int tamanho) {
		_tamanho = tamanho;
		_toString = "Disco Tamanho " + tamanho;
		_hashCode = tamanho;
	}
	public int getTamanho() {
		return _tamanho;
	}
	public int compareTo(Object o) {
		if (!(o instanceof Disco)) return 0;
		return _tamanho - ((Disco)o).getTamanho();
	}
	public String toString() {
		return _toString;
	}
	public boolean equals(Object o) {
		if (!(o instanceof Disco))
			return false;
		return ((Disco)o).getTamanho() == this.getTamanho();
	}
	public int hashCode() {
		return _hashCode;
	}
}