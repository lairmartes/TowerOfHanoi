package martes.lairjunior.usjt.algesd.hanoi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DiscoTest {

    private static int SIZE_BASE = 30;
    private static int SIZE_HIGH = 40;
    private static int SIZE_LOW = 20;

    private static Disco DISK_BASE = new Disco(SIZE_BASE);
    private static Disco DISK_HIGH = new Disco(SIZE_HIGH);
    private static Disco DISK_LOW = new Disco(SIZE_LOW);

    private static int COMPARE_TO_EQUAL_OBJECTS = 0;

    @Test
    @DisplayName("Testing disk size")
    void testDiskSizeAfterCreation() {

        int sizeTest = 3;
        Disco diskTest = new Disco(sizeTest);
        assertEquals(diskTest.getTamanho(), sizeTest);
    }

    @Test
    @DisplayName("Testing comparison disks with same size")
    void compareToEqualDisks() {

        assertEquals(DISK_BASE.compareTo(DISK_BASE), COMPARE_TO_EQUAL_OBJECTS);
        assertNotEquals(DISK_BASE.compareTo(DISK_HIGH), COMPARE_TO_EQUAL_OBJECTS);
        assertNotEquals(DISK_BASE.compareTo(DISK_LOW), COMPARE_TO_EQUAL_OBJECTS);
    }

    @Test
    @DisplayName("Testing higher disks")
    void compareToHigherDisks() {

        assert(DISK_BASE.compareTo(DISK_HIGH) > COMPARE_TO_EQUAL_OBJECTS);
    }

    @Test
    @DisplayName("Testing lower disks")
    void compareToLowerDisks() {

        assert(DISK_BASE.compareTo(DISK_LOW) < COMPARE_TO_EQUAL_OBJECTS);
    }

    void equals() {
    }
}