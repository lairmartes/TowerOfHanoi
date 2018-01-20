package martes.lairjunior.usjt.algesd.hanoi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiskTest {

    private static int SIZE_BASE = 30;
    private static int SIZE_HIGH = 40;
    private static int SIZE_LOW = 20;

    private static Disk DISK_BASE = new Disk(SIZE_BASE);
    private static Disk DISK_HIGH = new Disk(SIZE_HIGH);
    private static Disk DISK_LOW = new Disk(SIZE_LOW);

    private static int COMPARE_TO_EQUAL_OBJECTS = 0;

    @Test
    @DisplayName("Checking if the disk has the size it has been created")
    void testDiskSizeAfterCreation() {

        int sizeTest = 3;
        Disk diskTest = new Disk(sizeTest);
        assertEquals(diskTest.getSize(), sizeTest);
    }

    @Test
    @DisplayName("Comparing same size disks")
    void compareToEqualDisks() {

        Disk diskWithSizeOfBaseDisk = new Disk(SIZE_BASE);

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
        Disk disk1 = new Disk(3);
        Disk disk2 = new Disk(3);

        assertTrue(disk1.equals(disk2));
    }
}