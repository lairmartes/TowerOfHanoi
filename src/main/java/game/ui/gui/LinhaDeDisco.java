/*
 * LinhaDeDisco.java
 *
 * Created on 27 de Setembro de 2005, 02:56
 *
 */

package game.ui.gui;

import com.martialdev.game.hanoitower.core.control.Disk;

public class LinhaDeDisco {
    private String _linhaPrincipal;
    private String _linhaSimetrica;
    private final static String LINHA_EM_BRANCO = "          ";
    private final static int TAMANHO_MAXIMO_LINHA = 10;
    /** Creates a new instance of LinhaDeDisco */
    public LinhaDeDisco(Disk disco) {
        int diferenca = TAMANHO_MAXIMO_LINHA - disco.getSize();
        _linhaPrincipal = LINHA_EM_BRANCO.substring(TAMANHO_MAXIMO_LINHA - diferenca);
        _linhaPrincipal = _linhaPrincipal + LINHA_EM_BRANCO.substring(diferenca).replace(' ','_');
        _linhaSimetrica = LINHA_EM_BRANCO.substring(0,
                                                    disco
                                                            .getSize())
                                                            .replace(' ','_') + LINHA_EM_BRANCO
                                                            .substring(disco.getSize());
    }
    public String toString() {
        return _linhaPrincipal + _linhaSimetrica;
    }
}
