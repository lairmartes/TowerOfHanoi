package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.hanoi.exception.MovimentoInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


class PinoTest {

    private static final GerenciadorDoJogo GAME_MANAGER_INSTANCE = GerenciadorDoJogo.getInstance();

    @Test
    @DisplayName("Adding disks to the pin in correct order")
    void addDisksCorrectly() {
        Pino pin = new Pino();
        Disk disk1 = new Disk(1);
        Disk disk2 = new Disk(2);

        try {
            pin.adicionar(disk2);
            pin.adicionar(disk1);
        } catch (MovimentoInvalidoException e) {
            Assertions.fail("An invalid move error was notified incorrectly.");
        }
    }

    @Test
    @DisplayName("Adding disks with size zero")
    void addDiskSizeZero() {
        Pino pin = new Pino();

        Executable executionAddDisk = () -> pin.adicionar(Disk.DISK_ZERO);

        Assertions.assertThrows(MovimentoInvalidoException.class,
                                executionAddDisk,
                        "Should raise invalid move exception since a DISCO ZERO has been included.");
    }
    @Test
    @DisplayName("Adding greater disks above lesser disks")
    void addGreaterDiskOnLesserDisk() {
        Pino pin = new Pino();

        Disk disk1 = new Disk(1);
        Disk disk2 = new Disk(2);

        try {
            pin.adicionar(disk1);
        } catch (MovimentoInvalidoException e) {
            Assertions.fail("A valid move was detected as invalid move incorrectly");
            return;
        }

        Executable executionAddDisk = () -> pin.adicionar(disk2);

        Assertions.assertThrows(MovimentoInvalidoException.class,
                                executionAddDisk,
                        "An exception should be raised since a greater disk has been put above a lesser disk");
    }

    @Test
    @DisplayName("Removing disks from a regular pin")
    void removeDiskFromRegularPin() {
        Pino pin = new Pino();

        Disk diskTest2 = new Disk(2);
        Disk diskTest1 = new Disk(1);
        try {
            pin.adicionar(diskTest2);
            pin.adicionar(diskTest1);
        } catch (MovimentoInvalidoException e) {
            Assertions.fail("A disk has been included, but an illegal movement has been detected");
            return;
        }
        Disk diskRemoved = Disk.DISK_ZERO;
        try {
            diskRemoved = pin.removerDisco();
        } catch (MovimentoInvalidoException e) {
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

        Pino pinTest = new Pino(); /* TODO: remove no param constructor */
        pinTest.iniciarPilhaDeDiscos(diskArrayTest.length);

        try {
            pinTest.adicionar(diskArrayTest[3]);
            pinTest.adicionar(diskArrayTest[2]);
            pinTest.adicionar(diskArrayTest[1]);
            pinTest.adicionar(diskArrayTest[0]);
        } catch (MovimentoInvalidoException e) {
            Assertions.fail("An invalid move was incorrectly detected while testing");
        }

        Object[] recoveredDisks = pinTest.getDiscos();

        /* testing disks inputed and recovered */ {
            int count = 0;
            for (int i = diskArrayTest.length - 1; i >= 0; i--) {
                Assertions.assertTrue(diskArrayTest[i] == recoveredDisks[count++]);
            }
        }
    }

    @Test
    void iniciarPilhaDeDiscos() {
        /* TODO: Turn Pino.iniciarPilhaDeDiscos without parameters a private method */
    }
}