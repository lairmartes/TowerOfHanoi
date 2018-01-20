package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.hanoi.event.GameOverEvent;
import martes.lairjunior.usjt.algesd.hanoi.event.GameStartEvent;
import martes.lairjunior.usjt.algesd.hanoi.event.HanoiTowerListener;
import martes.lairjunior.usjt.algesd.hanoi.event.PinEvent;
import martes.lairjunior.usjt.algesd.hanoi.exception.InvalidMoveException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static martes.lairjunior.usjt.algesd.hanoi.HanoiTowerControl.PinPosition.*;

class HanoiTowerControlTest {


    private Disk toBeMoved;
    private HanoiTowerControl _matchTest;
    private int _disksAdded;
    private int _disksRemoved;
    private boolean _gameOverEventDetected;
    private boolean _gameStartEventDetected;
    private double _finalGameScore;

    private HanoiTowerListener _listener = new HanoiTowerListener() {

        @Override
        public void fireDiskAdded(PinEvent event) {
            _disksAdded++;
        }

        @Override
        public void hanoiTowerEvent(GameOverEvent event) {
            _gameOverEventDetected = true;

            setFinalGameScore(event.getScore());
        }

        @Override
        public void fireDiskRemoved(PinEvent event) {
            _disksRemoved++;
        }

        @Override
        public void hanoiTowerEvent(GameStartEvent event) {
            _gameStartEventDetected = true;
        }
    };

    @Test
    @DisplayName("Play with 3 disks and 7 moves")
    void playTheGame() {

        _disksAdded = 0;
        _disksRemoved = 0;
        _gameOverEventDetected = false;
        _gameStartEventDetected = false;


        _matchTest = new HanoiTowerControl();
        _matchTest.addListener(_listener);
        _matchTest.startGame(3);

        // Fist move - Disk 1 from Pin 1 to Pin 3
        this.firstMove();
        // Second move - Disk 2 from Pin 1 to Pin 2
        this.secondMove();
        // Third move - Disk 1 from Pin 3 to Pin 2
        this.thirdMove();
        //Fourth move - Disk 3 from Pin 1 to Pin 3
        this.fourthMove();
        // Fifth move - Disk 1 from Pin 2 to Pin 1
        this.fifthMove();
        // Sixth move - Disk 2 from Pin 2 to Pin 3
        this.sixthMove();
        // Final move - Disk 1 from Pin 1 to Pin 3
        this.finalMove();

        // Check if game is over and score is perfect
        this.checkGameScore();

        // Check if events have been broadcast.
        this.checkEvents(7);
    }

    void firstMove() {
        try {
            String invalidAssertPrefix = "In the first move, %s";

            toBeMoved = _matchTest.selectFromPin(FIRST);
            _matchTest.moveSelectedToPin(THIRD);

            // Check if disk moved has the correct size
            Assertions.assertEquals(1, toBeMoved.getSize(),
                    String.format(invalidAssertPrefix, "the first disk should be size 1"));

            // Check if pins have the correct disk quantity
            Assertions.assertEquals(2, _matchTest.currentStackSize(FIRST),
                    String.format(invalidAssertPrefix, "the first pin must have two disks"));
            Assertions.assertEquals(1, _matchTest.currentStackSize(THIRD),
                    "Must have 1 disk since one disk has been included");

        } catch (InvalidMoveException e) {
            // No invalid moves are done in this test
            Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
        }
    }

    void secondMove() {

        try {
            String invalidAssertPrefix = "In the second move, %s.";

            toBeMoved = _matchTest.selectFromPin(FIRST);
            _matchTest.moveSelectedToPin(SECOND);
            Assertions.assertEquals(2, toBeMoved.getSize(),
                    String.format(invalidAssertPrefix, "the second disk should have size 2"));
            Assertions.assertEquals(1, _matchTest.currentStackSize(FIRST),
                    String.format(invalidAssertPrefix, "the first pin should have only one disk"));
            Assertions.assertEquals(1, _matchTest.currentStackSize(SECOND),
                    String.format(invalidAssertPrefix, "the second pin should have only one disk"));
        } catch (InvalidMoveException e) {
            Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
        }
    }

    void thirdMove() {

        try {
            String invalidAssertPrefix = "In the third move, %s.";

            toBeMoved = _matchTest.selectFromPin(THIRD);
            _matchTest.moveSelectedToPin(SECOND);
            Assertions.assertEquals(1, toBeMoved.getSize(),
                    String.format(invalidAssertPrefix, "the disk should have size one"));
            Assertions.assertEquals(0, _matchTest.currentStackSize(THIRD),
                    String.format(invalidAssertPrefix, "the third pin should have zero disks"));
            Assertions.assertEquals(2, _matchTest.currentStackSize(SECOND),
                    String.format(invalidAssertPrefix, "the second pin should have two disks"));
        } catch (InvalidMoveException e) {
            Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
        }
    }

    void fourthMove() {

        try {
            String invalidAssertPrefix = "In the fourth move, %s.";

            toBeMoved = _matchTest.selectFromPin(FIRST);
            _matchTest.moveSelectedToPin(THIRD);
            Assertions.assertEquals(3, toBeMoved.getSize(),
                    String.format(invalidAssertPrefix, "the disk should have size three"));
            Assertions.assertEquals(0, _matchTest.currentStackSize(FIRST),
                    String.format(invalidAssertPrefix, "the first pin should have no disks"));
            Assertions.assertEquals(1, _matchTest.currentStackSize(THIRD),
                    String.format(invalidAssertPrefix, "the third pin should have one disk"));

        } catch (InvalidMoveException e) {
            Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
        }
    }

    void fifthMove() {

        try {
            String invalidAssertPrefix = "In the fifth move, %s.";

            toBeMoved = _matchTest.selectFromPin(SECOND);
            _matchTest.moveSelectedToPin(FIRST);
            Assertions.assertEquals(1, toBeMoved.getSize(),
                    String.format(invalidAssertPrefix, "the disk should have size one"));
            Assertions.assertEquals(1, _matchTest.currentStackSize(SECOND),
                    String.format(invalidAssertPrefix, "the second pin should have one disk"));
            Assertions.assertEquals(1, _matchTest.currentStackSize(FIRST),
                    String.format(invalidAssertPrefix, "the first pin should have one disk"));

        } catch (InvalidMoveException e) {
            Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
        }
    }

    void sixthMove() {

        try {
            String invalidAssertPrefix = "In the sixth move, %s.";

            toBeMoved = _matchTest.selectFromPin(SECOND);
            _matchTest.moveSelectedToPin(THIRD);
            Assertions.assertEquals(2, toBeMoved.getSize(),
                    String.format(invalidAssertPrefix, "the disk should have size two"));
            Assertions.assertEquals(0, _matchTest.currentStackSize(SECOND),
                    String.format(invalidAssertPrefix, "the second pin should have no disks"));
            Assertions.assertEquals(2, _matchTest.currentStackSize(THIRD),
                    String.format(invalidAssertPrefix, "the third pin should have two disks"));
        } catch (InvalidMoveException e) {
            Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
        }
    }

    void finalMove() {
        try {
            String invalidAssertPrefix = "In the final move, %s.";

            toBeMoved = _matchTest.selectFromPin(FIRST);
            _matchTest.moveSelectedToPin(THIRD);
            Assertions.assertEquals(1, toBeMoved.getSize(),
                    String.format(invalidAssertPrefix, "the disk should have size one"));
            Assertions.assertEquals(0, _matchTest.currentStackSize(FIRST),
                    String.format(invalidAssertPrefix, "the first pin should have no disks."));
            Assertions.assertEquals(3, _matchTest.currentStackSize(THIRD),
                    String.format(invalidAssertPrefix, "the third pin should have three disks"));

        } catch (InvalidMoveException e) {
            Assertions.fail("A invalid move has been detected incorrectly: " + e.getMessage());
        }
    }

    void setFinalGameScore(double score) {
        this._finalGameScore = score;
    }
    void checkGameScore() {
        Assertions.assertEquals(1d, this._finalGameScore, "Game should be finished flawless.");
    }

    void checkEvents(int expectedMoves) {
        String moveMessage = String.format("%d disks are expected to be added", expectedMoves);

        Assertions.assertEquals(7, _disksAdded, expectedMoves);
        Assertions.assertEquals(7, _disksRemoved, expectedMoves);
        Assertions.assertTrue(_gameOverEventDetected, "A game over event should be broadcast.");
        Assertions.assertTrue(_gameStartEventDetected, "A game start event should be broadcast.");
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


