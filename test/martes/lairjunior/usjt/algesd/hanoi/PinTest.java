package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.hanoi.exception.InvalidMoveException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


class PinTest {

    private static final GerenciadorDoJogo GAME_MANAGER_INSTANCE = GerenciadorDoJogo.getInstance();

    @Test
    @DisplayName("Adding disks to the pin in correct order")
    void addDisksCorrectly() {
        Pin pin = new Pin(4);
        Disk disk1 = new Disk(1);
        Disk disk2 = new Disk(2);

        try {
            pin.add(disk2);
            pin.add(disk1);
        } catch (InvalidMoveException e) {
            Assertions.fail("An invalid move error was notified incorrectly.");
        }
    }

    @Test
    @DisplayName("Adding disks with size zero")
    void addDiskSizeZero() {
        Pin pin = new Pin(5);

        Executable executionAddDisk = () -> pin.add(Disk.DISK_ZERO);

        Assertions.assertThrows(InvalidMoveException.class,
                                executionAddDisk,
                        "Should raise invalid move exception since a DISCO ZERO has been included.");
    }
    @Test
    @DisplayName("Adding greater disks above lesser disks")
    void addGreaterDiskOnLesserDisk() {
        Pin pin = new Pin(5);

        Disk disk1 = new Disk(1);
        Disk disk2 = new Disk(2);

        try {
            pin.add(disk1);
        } catch (InvalidMoveException e) {
            Assertions.fail("A valid move was detected as invalid move incorrectly");
            return;
        }

        Executable executionAddDisk = () -> pin.add(disk2);

        Assertions.assertThrows(InvalidMoveException.class,
                                executionAddDisk,
                        "An exception should be raised since a greater disk has been put above a lesser disk");
    }

    @Test
    @DisplayName("Removing disks from a regular pin")
    void removeDiskFromRegularPin() {
        Pin pin = new Pin(5);

        Disk diskTest2 = new Disk(2);
        Disk diskTest1 = new Disk(1);
        try {
            pin.add(diskTest2);
            pin.add(diskTest1);
        } catch (InvalidMoveException e) {
            Assertions.fail("A disk has been included, but an illegal movement has been detected");
            return;
        }
        Disk diskRemoved = Disk.DISK_ZERO;
        try {
            diskRemoved = pin.removeDisk();
        } catch (InvalidMoveException e) {
            Assertions.fail("A disk has been removed from pin correctly, but an illegal movement has been detected");
        }

        Assertions.assertTrue(diskRemoved == diskTest1,
                "Removed disk should be the last disk included in the pin");
    }

    @Test
    @DisplayName("Check if the list of disks can be recovered correctly")
    void getDiscos() {

        Disk[] diskArrayTest = new Disk[4];

        diskArrayTest[0] = new Disk(1);
        diskArrayTest[1] = new Disk(2);
        diskArrayTest[2] = new Disk(3);
        diskArrayTest[3] = new Disk(4);

        Pin pinTest = new Pin(3);
        pinTest.reset(diskArrayTest.length);

        try {
            pinTest.add(diskArrayTest[3]);
            pinTest.add(diskArrayTest[2]);
            pinTest.add(diskArrayTest[1]);
            pinTest.add(diskArrayTest[0]);
        } catch (InvalidMoveException e) {
            Assertions.fail("An invalid move was incorrectly detected while testing");
        }

        Object[] recoveredDisks = pinTest.getDisks();

        /* testing disks inputed and recovered */ {
            int count = 0;
            for (int i = diskArrayTest.length - 1; i >= 0; i--) {
                Assertions.assertTrue(diskArrayTest[i] == recoveredDisks[count++]);
            }
        }
    }

}