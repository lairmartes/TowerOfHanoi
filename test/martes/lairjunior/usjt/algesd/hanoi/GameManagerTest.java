package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.hanoi.exception.InvalidMoveException;
import org.junit.jupiter.api.*;

import static martes.lairjunior.usjt.algesd.hanoi.GameManager.PinSequence.FIRST;
import static martes.lairjunior.usjt.algesd.hanoi.GameManager.PinSequence.SECOND;
import static martes.lairjunior.usjt.algesd.hanoi.GameManager.PinSequence.THIRD;

class GameManagerTest {

    private GameManager _matchTest;

    @BeforeAll
    void Setup() {
        _matchTest = GameManager.getInstance();
    }

    @Test
    @DisplayName("Let's play with 3 disk and 7 moves")
    void letsPlay() {

        try {

            // First move - move disk 1 from pin 1 to pin 3.
            Disk disk1 = _matchTest.getPino(GameManager.PIN_1).removeDisk();
            _matchTest.getPino(GameManager.PIN_3).add(disk1);
            _matchTest.incrementarMovimentos();

            // Second move - move disk 2 from pin 1 to pin 2
            Disk disk2 = _matchTest.getPino(GameManager.PIN_1).removeDisk();
            _matchTest.getPino(GameManager.PIN_2).add(disk2);
            _matchTest.incrementarMovimentos();

            // Third move - move disk 1 from pin 3 to pin 2
            disk1 = _matchTest.getPino(GameManager.PIN_3).removeDisk();
            _matchTest.getPino(GameManager.PIN_2).add(disk1);
            _matchTest.incrementarMovimentos();

            // Fourth move - move disk 3 from pin 1 to pin 3
            Disk disk3 = _matchTest.getPino(GameManager.PIN_1).removeDisk();
            _matchTest.getPino(GameManager.PIN_3).add(disk3);
            _matchTest.incrementarMovimentos();

            // Fifth move - move disk 1 from pin 2 to pin 1
            disk1 = _matchTest.getPino(GameManager.PIN_2).removeDisk();
            _matchTest.getPino(GameManager.PIN_1).add(disk1);
            _matchTest.incrementarMovimentos();

            // Sixth move - move disk 2 from pin 2 to pin 3
            disk2 = _matchTest.getPino(GameManager.PIN_2).removeDisk();
            _matchTest.getPino(GameManager.PIN_3).add(disk2);
            _matchTest.incrementarMovimentos();

            // Seventh move - move disk 1 fromm pin 1 to pin 3
            disk1 = _matchTest.getPino(GameManager.PIN_1).removeDisk();
            _matchTest.getPino(GameManager.PIN_3).add(disk1);
            _matchTest.incrementarMovimentos();

            // check if the match is over
            Assertions.assertTrue(_matchTest.isJogoTerminado());

            // check if the match has been concluded in seven moves
            Assertions.assertEquals(_matchTest.getQuantidadeDeMovimentos(), 7);

        } catch (InvalidMoveException e) {
            Assertions.fail("An error was incorrectly detected while doing test moves: " + e.getMessage());
        }
    }

    @Nested
    @DisplayName("Play with 3 disks and 7 moves")
    class PlayWithMinimunMoves {

        Disk toBeMoved;
        Disk[] pinsInDisk;

        @Test
        @DisplayName("First move - Disk 1 from Pin 1 to Pin 2")
        void firstMove() {
            try {
                toBeMoved = _matchTest.selectFromPin(FIRST);
                _matchTest.moveSelectedToPin(THIRD);
                Assertions.assertEquals(toBeMoved.getSize(),
                        1,
                        "The first disk should be size 1");
                // Check involved pins stack
                pinsInDisk = _matchTest.clonedPinStack(FIRST);
                Assertions.assertEquals(pinsInDisk.length,
                        2,
                        "Must have 2 disks since one disk has been removed");
                pinsInDisk = _matchTest.clonedPinStack(THIRD);
                Assertions.assertEquals(pinsInDisk.length,
                        1,
                        "Must have 1 disk since one disk has been included");
            } catch (InvalidMoveException e) {
                Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
            }



            /* Second move */
            {
                toBeMoved = _matchTest.selectFromPin(FIRST);
                _matchTest.moveSelectedToPin(FIRST, SECOND);
                Assertions.assertEquals(toBeMoved.getSize(),
                        2,
                        "The second disk must have size 2");
                pinsInDisk = _matchTest.clonePinStack(FIRST);
                Assertions.assertEquals(pinsInDisk.length,
                        1,
                        "Must have only one disk, since two disks have been moved to pin 3 and 2");
                pinsInDisk = _matchTest.clonePinStack(SECOND);
                Assertions.assertEquals(pinsInDisk.length,
                        1,
                        "Must have only one disk, since there's no disk before last move");
            }

            /* Third move */
            {
                toBeMoved = _matchTest.selectFromPin(THIRD);
                _matchTest.moveSelectedToPin(SECOND);
                Assertions.assertEquals(toBeMoved.getSize(), 1);
            }

            toBeMoved = _matchTest.selectFromPin(FIRST);
            _matchTest.moveSelectedToPin(THIRD);
            Assertions.assertEquals(toBeMoved.getSize(), 3);

            toBeMoved = _matchTest.selectFromPin(SECOND);
            _matchTest.moveSelectedToPin(FIRST);

            toBeMoved = _matchTest.selectFromPin(SECOND);
            _matchTest.moveSelectedToPin(THIRD);

            toBeMoved = _matchTest.selectFromPin(FIRST);
            _matchTest.moveSelectedToPin(THIRD);

        } catch(
        InvalidMoveException e)

        {
            Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
        }
    }
}

}