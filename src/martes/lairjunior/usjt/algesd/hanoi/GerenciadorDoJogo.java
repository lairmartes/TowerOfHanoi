/*
 * Criado em 26/09/2005
 *
 * Para alterar o gabarito para este arquivo gerado vá para
 * Janela&gt;Preferências&gt;Java&gt;Geração de Códigos&gt;Código e Comentários
 */
package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.hanoi.exception.MovimentoInvalidoException;

/**
 * @author alunos
 *
 * Para alterar o gabarito para este comentário do tipo gerado vá para
 * Janela&gt;Preferências&gt;Java&gt;Geração de Códigos&gt;Código e Comentários
 */
public class GerenciadorDoJogo {
	private static GerenciadorDoJogo _instance;
	private int _quantidadeDeMovimentos;
	public static final int PINO_1 = 0;
	public static final int PINO_2 = 1;
	public static final int PINO_3 = 2;
	private static final int QUANTIDADE_PINOS = 3;
	public static final int QUANTIDADE_DEFAULT_DISCOS = 3;
	private Pino[] _pinosDoJogo;
	private Disco _discoAtual;
	private int _quantidadeDeDiscos = QUANTIDADE_DEFAULT_DISCOS;
	private Disco[] _discosDoJogo = new Disco[_quantidadeDeDiscos];
	private GerenciadorDoJogo() {

	}
	public static GerenciadorDoJogo getInstance() {
		if (_instance == null) {
			_instance = new GerenciadorDoJogo();
			_instance._pinosDoJogo = new Pino[QUANTIDADE_PINOS];
			for (int i=0; i<QUANTIDADE_PINOS; i++) {
				_instance._pinosDoJogo[i] = new Pino();
			}
			_instance.iniciarJogo();
		}
		return _instance;
	}
	public void setDiscoAtual(Disco disco) {
		_discoAtual = disco;
	}
	public Disco getDiscoAtual() {
		return _discoAtual;
	}
	public void incrementarMovimentos() {
		_quantidadeDeMovimentos++;
	}
	public void iniciarJogo() {
		_discoAtual = new Disco(0);
		_quantidadeDeMovimentos = 0;
		iniciarDiscos();
		iniciarPinos();		
	}
	private void iniciarDiscos() {
		_discosDoJogo = new Disco[_quantidadeDeDiscos];
		for (int i=0; i<_quantidadeDeDiscos; i++) {
			_discosDoJogo[i] = new Disco(i+1);
		}
	}
	private void iniciarPinos() {
		for (int i=0; i<QUANTIDADE_PINOS; i++) {
			_pinosDoJogo[i].iniciarPilhaDeDiscos();
		}
		iniciarPrimeiroPino();
	}
	private void iniciarPrimeiroPino() {
		try {
			for (int i=_quantidadeDeDiscos-1; i >= 0; i--)
				_pinosDoJogo[PINO_1].adicionar(_discosDoJogo[i]);
		}
		catch (MovimentoInvalidoException e) {
			e.printStackTrace();
		}
	}
	public Pino getPino(int numeroDoPino) {
			return _pinosDoJogo[numeroDoPino];
	}
	public int getQuantidadeDeDiscos() {
		return _quantidadeDeDiscos;
	}
	public void setQuantidadeDeDiscos(int quantidade) {
		_quantidadeDeDiscos = quantidade;
	}
	public int getQuantidadeDeMovimentos() {
		return _quantidadeDeMovimentos;
	}
	public boolean isJogoTerminado() {
		int quantidadeDeDiscosDoPino1 = 0;
		Object[] relacaoDiscosPino1 = getPino(PINO_1).getDiscos(); 
		for (int i=0;i<relacaoDiscosPino1.length; i++) {
			if (((Disco)relacaoDiscosPino1[i]).getTamanho() > 0)
				quantidadeDeDiscosDoPino1++;
		}
		if (quantidadeDeDiscosDoPino1 > 0) return false;

		int quantidadeDeDiscosDoPino3 = _quantidadeDeDiscos;
		Object[] relacaoDiscosPino3 = getPino(PINO_3).getDiscos();
		for (int i=0;i<relacaoDiscosPino3.length; i++) {
			if (((Disco)relacaoDiscosPino3[i]).getTamanho() > 0)
			quantidadeDeDiscosDoPino3--;
		}
		if (quantidadeDeDiscosDoPino3 > 0) return false;
		return true;
	}
}