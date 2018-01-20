package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.hanoi.exception.InvalidMoveException;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static martes.lairjunior.usjt.algesd.hanoi.HanoiTowerControl.PinSequence.FIRST;
import static martes.lairjunior.usjt.algesd.hanoi.HanoiTowerControl.PinSequence.SECOND;
import static martes.lairjunior.usjt.algesd.hanoi.HanoiTowerControl.PinSequence.THIRD;

class HanoiTowerControlTest {

    private HanoiTowerControl _matchTest = HanoiTowerControl.getInstance();

    @Test
    @DisplayName("Let's play with 3 disk and 7 moves")
    void letsPlay() {

        try {

            // First move - move disk 1 from pin 1 to pin 3.
            Disk disk1 = _matchTest.getPino(HanoiTowerControl.PIN_1).removeDisk();
            _matchTest.getPino(HanoiTowerControl.PIN_3).add(disk1);
            _matchTest.incrementarMovimentos();

            // Second move - move disk 2 from pin 1 to pin 2
            Disk disk2 = _matchTest.getPino(HanoiTowerControl.PIN_1).removeDisk();
            _matchTest.getPino(HanoiTowerControl.PIN_2).add(disk2);
            _matchTest.incrementarMovimentos();

            // Third move - move disk 1 from pin 3 to pin 2
            disk1 = _matchTest.getPino(HanoiTowerControl.PIN_3).removeDisk();
            _matchTest.getPino(HanoiTowerControl.PIN_2).add(disk1);
            _matchTest.incrementarMovimentos();

            // Fourth move - move disk 3 from pin 1 to pin 3
            Disk disk3 = _matchTest.getPino(HanoiTowerControl.PIN_1).removeDisk();
            _matchTest.getPino(HanoiTowerControl.PIN_3).add(disk3);
            _matchTest.incrementarMovimentos();

            // Fifth move - move disk 1 from pin 2 to pin 1
            disk1 = _matchTest.getPino(HanoiTowerControl.PIN_2).removeDisk();
            _matchTest.getPino(HanoiTowerControl.PIN_1).add(disk1);
            _matchTest.incrementarMovimentos();

            // Sixth move - move disk 2 from pin 2 to pin 3
            disk2 = _matchTest.getPino(HanoiTowerControl.PIN_2).removeDisk();
            _matchTest.getPino(HanoiTowerControl.PIN_3).add(disk2);
            _matchTest.incrementarMovimentos();

            // Seventh move - move disk 1 fromm pin 1 to pin 3
            disk1 = _matchTest.getPino(HanoiTowerControl.PIN_1).removeDisk();
            _matchTest.getPino(HanoiTowerControl.PIN_3).add(disk1);
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
    class Game {

        Disk toBeMoved;
        HanoiTowerControl _matchTest;

        @Before
        void Setup() {
            _matchTest = new HanoiTowerControl();
            _matchTest.startGame(3);
        }

        @Test
        @DisplayName("First move - Disk 1 from Pin 1 to Pin 3")
        void firstMove() {
            try {
                String invalidAssertPrefix = "In the first move, %s";

                toBeMoved = _matchTest.selectFromPin(FIRST);
                _matchTest.moveSelectedToPin(THIRD);

                // Check if disk moved has the correct size
                Assertions.assertEquals(1, toBeMoved.getSize(),
                        String.format(invalidAssertPrefix, "the first disk should be size 1"));

                // Check if pins have the correct disk quantity
                Assertions.assertEquals(2, _matchTest.clonePinStack(FIRST).length,
                        String.format(invalidAssertPrefix, "the first pin must have two disks"));
                Assertions.assertEquals(1, _matchTest.clonePinStack(THIRD).length,
                        "Must have 1 disk since one disk has been included");

            } catch (InvalidMoveException e) {
                // No invalid moves are done in this test
                Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
            }
        }

        @Test
        @DisplayName("Second move - Disk 2 from Pin 1 to Pin 2")
        void secondMove() {

            try {
                String invalidAssertPrefix = "In the second move, %s.";

                toBeMoved = _matchTest.selectFromPin(FIRST);
                _matchTest.moveSelectedToPin(SECOND);
                Assertions.assertEquals(2, toBeMoved.getSize(),
                        String.format(invalidAssertPrefix, "the second disk should have size 2"));
                Assertions.assertEquals(1, _matchTest.clonePinStack(FIRST).length,
                        String.format(invalidAssertPrefix, "the first pin should have only one disk"));
                Assertions.assertEquals(1, _matchTest.clonePinStack(SECOND).length,
                        String.format(invalidAssertPrefix, "the second pin should have only one disk"));
            } catch (InvalidMoveException e) {
                Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
            }
        }

        @Test
        @DisplayName("Third move - Disk 1 from Pin 3 to Pin 2")
        void thirdMove() {

            try {
                String invalidAssertPrefix = "In the third move, %s.";

                toBeMoved = _matchTest.selectFromPin(THIRD);
                _matchTest.moveSelectedToPin(SECOND);
                Assertions.assertEquals(1, toBeMoved.getSize(),
                        String.format(invalidAssertPrefix, "the disk should have size one"));
                Assertions.assertEquals(0, _matchTest.clonePinStack(THIRD).length,
                        String.format(invalidAssertPrefix, "the third pin should have zero disks"));
                Assertions.assertEquals(2, _matchTest.clonePinStack(SECOND).length,
                        String.format(invalidAssertPrefix, "the second pin should have two disks"));
            } catch (InvalidMoveException e) {
                Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
            }
        }

        @Test
        @DisplayName("Fourth move - Disk 3 from Pin 1 to Pin 3")
        void fourthMove() {

            try {
                String invalidAssertPrefix = "In the fourth move, %s.";

                toBeMoved = _matchTest.selectFromPin(FIRST);
                _matchTest.moveSelectedToPin(THIRD);
                Assertions.assertEquals(3, toBeMoved.getSize(),
                        String.format(invalidAssertPrefix, "the disk should have size three"));
                Assertions.assertEquals(0, _matchTest.clonePinStack(FIRST).length,
                        String.format(invalidAssertPrefix, "the first pin should have no disks"));
                Assertions.assertEquals(1, _matchTest.clonePinStack(THIRD).length,
                        String.format(invalidAssertPrefix, "the third pin should have one disk"));

            } catch (InvalidMoveException e) {
                Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
            }
        }

        @Test
        @DisplayName("Fifth move - Disk 1 from Pin 2 to Pin 1")
        void fifthMove() {

            try {
                String invalidAssertPrefix = "In the fifth move, %s.";

                toBeMoved = _matchTest.selectFromPin(SECOND);
                _matchTest.moveSelectedToPin(FIRST);
                Assertions.assertEquals(1, toBeMoved.getSize(),
                        String.format(invalidAssertPrefix, "the disk should have size one"));
                Assertions.assertEquals(1, _matchTest.clonePinStack(SECOND).length,
                        String.format(invalidAssertPrefix, "the second pin should have one disk"));
                Assertions.assertEquals(1, _matchTest.clonePinStack(FIRST).length,
                        String.format(invalidAssertPrefix, "the first pin should have one disk"));

            } catch (InvalidMoveException e) {
                Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
            }
        }

        @Test
        @DisplayName("Sixth move - Disk 2 from Pin 2 to Pin 3")
        void sixthMove() {

            try {
                String invalidAssertPrefix = "In the sixth move, %s.";

                toBeMoved = _matchTest.selectFromPin(SECOND);
                _matchTest.moveSelectedToPin(THIRD);
                Assertions.assertEquals(1, toBeMoved.getSize(),
                        String.format(invalidAssertPrefix, "the disk should have size two"));
                Assertions.assertEquals(0, _matchTest.clonePinStack(SECOND).length,
                        String.format(invalidAssertPrefix, "the second pin should have no disks"));
                Assertions.assertEquals(2, _matchTest.clonePinStack(THIRD).length,
                        String.format(invalidAssertPrefix, "the third pin should have two disks"));
            } catch (InvalidMoveException e) {
                Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
            }
        }

        @Test
        @DisplayName("Final move - Disk 1 from Pin 1 to Pin 3")
        void finalMove() {
            try {
                String invalidAssertPrefix = "In the final move, %s.";

                toBeMoved = _matchTest.selectFromPin(FIRST);
                _matchTest.moveSelectedToPin(THIRD);
                Assertions.assertEquals(1, toBeMoved.getSize(),
                        String.format(invalidAssertPrefix, "the disk should have size one"));
                Assertions.assertEquals(0, _matchTest.clonePinStack(FIRST).length,
                        String.format(invalidAssertPrefix, "the first pin should have no disks."));
                Assertions.assertEquals(3, _matchTest.clonePinStack(THIRD).length,
                        String.format(invalidAssertPrefix, "the third pin should have three disks"));

            } catch (InvalidMoveException e) {
                Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
            }
        }

        @Test
        @DisplayName("Check if game is over and score is perfect")
        void checkGameStatus() {
            Assertions.assertTrue(_matchTest.isGameOver(), "Game is not over, but it should be.");
            Assertions.assertEquals(1d, _matchTest.getScore(), "Game should be finished flawless.");
        }
    }

    @Test
    @DisplayName("Running invalid move")
    void invalidMove() {

        HanoiTowerControl _matchTest = new HanoiTowerControl();
        _matchTest.startGame(5);

        try {
            _matchTest.selectFromPin(FIRST);
            _matchTest.moveSelectedToPin(SECOND);

            _matchTest.selectFromPin(FIRST);
            Executable executeInvalidDiskMove = () -> _matchTest.moveSelectedToPin(SECOND);

            Assertions.assertThrows(InvalidMoveException.class, executeInvalidDiskMove,
                    "An exception should be thrown when trying to put a greater disk above a lesser.");
        } catch (InvalidMoveException e) {
            Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
        }
    }
}


