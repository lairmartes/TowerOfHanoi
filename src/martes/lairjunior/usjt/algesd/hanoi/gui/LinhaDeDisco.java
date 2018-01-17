/*
 * LinhaDeDisco.java
 *
 * Created on 27 de Setembro de 2005, 02:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package martes.lairjunior.usjt.algesd.hanoi.gui;

import martes.lairjunior.usjt.algesd.hanoi.Disco;

/**
 *
 * @author lair
 */
public class LinhaDeDisco {
    private String _linhaPrincipal;
    private String _linhaSimetrica;
    private final static String LINHA_EM_BRANCO = "          ";
    private final static int TAMANHO_MAXIMO_LINHA = 10;
    /** Creates a new instance of LinhaDeDisco */
    public LinhaDeDisco(Disco disco) {
        int diferenca = TAMANHO_MAXIMO_LINHA - disco.getTamanho();
        _linhaPrincipal = LINHA_EM_BRANCO.substring(TAMANHO_MAXIMO_LINHA - diferenca);
        _linhaPrincipal = _linhaPrincipal + LINHA_EM_BRANCO.substring(diferenca).replace(' ','_');
        _linhaSimetrica = LINHA_EM_BRANCO.substring(0, disco.getTamanho()).replace(' ','_') + LINHA_EM_BRANCO.substring(disco.getTamanho());
    }
    public String toString() {
        return _linhaPrincipal + _linhaSimetrica;
    }
}
