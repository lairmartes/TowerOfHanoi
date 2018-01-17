package martes.lairjunior.usjt.algesd.hanoi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscoTest {

    @Test
    @DisplayName("Testing disk size")
    void getTamanho() {

        int tamanhoTeste = 3;
        Disco diskTest = new Disco(tamanhoTeste);
        assertEquals(diskTest.getTamanho(), tamanhoTeste);
    }

    @Test
    @DisplayName("Testing comparison")
    void compareTo() {

        int sizeBase = 30;
        int sizeLow = 20;
        int sizeHigh = 40;

        Disco diskBase = new Disco(sizeBase);
        Disco diskLow = new Disco(sizeLow);
        Disco diskHigh = new Disco(sizeHigh);

        //boolean isTheSame = diskBase.compareTo(diskBase) == 0;
    }

    @Test
    void equals() {
    }
}