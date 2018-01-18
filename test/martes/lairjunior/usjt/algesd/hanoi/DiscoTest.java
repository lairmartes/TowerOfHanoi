package martes.lairjunior.usjt.algesd.hanoi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiscoTest {

    private static int SIZE_BASE = 30;
    private static int SIZE_HIGH = 40;
    private static int SIZE_LOW = 20;

    private static Disco DISK_BASE = new Disco(SIZE_BASE);
    private static Disco DISK_HIGH = new Disco(SIZE_HIGH);
    private static Disco DISK_LOW = new Disco(SIZE_LOW);

    private static int COMPARE_TO_EQUAL_OBJECTS = 0;

    @Test
    @DisplayName("Checking if the disk has the size it has been created")
    void testDiskSizeAfterCreation() {

        int sizeTest = 3;
        Disco diskTest = new Disco(sizeTest);
        assertEquals(diskTest.getTamanho(), sizeTest);
    }

    @Test
    @DisplayName("Comparing same size disks")
    void compareToEqualDisks() {

        Disco diskWithSizeOfBaseDisk = new Disco(SIZE_BASE);

        assertEquals(DISK_BASE.compareTo(diskWithSizeOfBaseDisk), COMPARE_TO_EQUAL_OBJECTS);
        assertNotEquals(DISK_BASE.compareTo(DISK_HIGH), COMPARE_TO_EQUAL_OBJECTS);
        assertNotEquals(DISK_BASE.compareTo(DISK_LOW), COMPARE_TO_EQUAL_OBJECTS);
    }

    @Test
    @DisplayName("Commparing a higher disk")
    void compareToHigherDisks() {

        assertTrue(DISK_BASE.compareTo(DISK_HIGH) < COMPARE_TO_EQUAL_OBJECTS);
    }

    @Test
    @DisplayName("Comparing a lesser disk")
    void compareToLowerDisks() {

        assertTrue(DISK_BASE.compareTo(DISK_LOW) > COMPARE_TO_EQUAL_OBJECTS);
    }

    @Test
    @DisplayName("Two disks are equals since they have the same size")
    void equals() {
        Disco disk1 = new Disco(3);
        Disco disk2 = new Disco(3);

        assertTrue(disk1.equals(disk2));
    }
}