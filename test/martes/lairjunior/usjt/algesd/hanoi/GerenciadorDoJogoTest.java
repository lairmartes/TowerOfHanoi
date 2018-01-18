package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.hanoi.exception.MovimentoInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GerenciadorDoJogoTest {

    @Test
    @DisplayName("Let's play with 3 disk and 7 moves")
    void letsPlay() {
        GerenciadorDoJogo matchTest = GerenciadorDoJogo.getInstance();

        try {

            // First move - move disk 1 from pin 1 to pin 3.
            Disk disk1 = matchTest.getPino(GerenciadorDoJogo.PINO_1).removerDisco();
            matchTest.getPino(GerenciadorDoJogo.PINO_3).adicionar(disk1);
            matchTest.incrementarMovimentos();

            // Second move - move disk 2 from pin 1 to pin 2
            Disk disk2 = matchTest.getPino(GerenciadorDoJogo.PINO_1).removerDisco();
            matchTest.getPino(GerenciadorDoJogo.PINO_2).adicionar(disk2);
            matchTest.incrementarMovimentos();

            // Third move - move disk 1 from pin 3 to pin 2
            disk1 = matchTest.getPino(GerenciadorDoJogo.PINO_3).removerDisco();
            matchTest.getPino(GerenciadorDoJogo.PINO_2).adicionar(disk1);
            matchTest.incrementarMovimentos();

            // Fourth move - move disk 3 from pin 1 to pin 3
            Disk disk3 = matchTest.getPino(GerenciadorDoJogo.PINO_1).removerDisco();
            matchTest.getPino(GerenciadorDoJogo.PINO_3).adicionar(disk3);
            matchTest.incrementarMovimentos();

            // Fifth move - move disk 1 from pin 2 to pin 1
            disk1 = matchTest.getPino(GerenciadorDoJogo.PINO_2).removerDisco();
            matchTest.getPino(GerenciadorDoJogo.PINO_1).adicionar(disk1);
            matchTest.incrementarMovimentos();

            // Sixth move - move disk 2 from pin 2 to pin 3
            disk2 = matchTest.getPino(GerenciadorDoJogo.PINO_2).removerDisco();
            matchTest.getPino(GerenciadorDoJogo.PINO_3).adicionar(disk2);
            matchTest.incrementarMovimentos();

            // Seventh move - move disk 1 fromm pin 1 to pin 3
            disk1 = matchTest.getPino(GerenciadorDoJogo.PINO_1).removerDisco();
            matchTest.getPino(GerenciadorDoJogo.PINO_3).adicionar(disk1);
            matchTest.incrementarMovimentos();

            // check if the match is over
            Assertions.assertTrue(matchTest.isJogoTerminado());

            // check if the match has been concluded in seven moves
            Assertions.assertEquals(matchTest.getQuantidadeDeMovimentos(), 7);

        } catch (MovimentoInvalidoException e) {
            Assertions.fail("An error was incorrectly detected while doing test moves: " + e.getMessage());
        }
    }

}