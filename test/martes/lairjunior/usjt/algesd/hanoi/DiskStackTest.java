package martes.lairjunior.usjt.algesd.hanoi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DiskStackTest {

    @Test
    @DisplayName("Initial stack must start with zero disks")
    void initializingStack() {

        int testQtty = 3;
        DiskStack stackTest = new DiskStack(testQtty);

        Assertions.assertEquals(stackTest.size(), 0); // no matter stack size, stack has zero disks
    }

    @Test
    @DisplayName("Test removing disks in a stack with higher capacity")
    void removingDisk() {

        int testQtty = 3;
        DiskStack stackTest = new DiskStack(testQtty);

        stackTest.pop();
        Assertions.assertEquals(stackTest.size(), 0); /* the capacity of the stack doesn't change
                                                                since there's no disks in stack */

        stackTest.pop();
        Assertions.assertEquals(stackTest.size(), 0);
    }

    @Test
    @DisplayName("Including disks in a stack with higher capacity")
    void addingDisk() {

        Disk diskTest = new Disk(3);
        int testQtty = 5; // stack with higher capacity

        DiskStack stackTest = new DiskStack(testQtty);

        stackTest.push(diskTest);
        Assertions.assertEquals(stackTest.size(), 1);

        stackTest.push(diskTest);
        Assertions.assertEquals(stackTest.size(), 2);
    }

    @Test
    @DisplayName("Push and pop content sequence")
    void sequencePushAndPop() {
        List<Disk> diskTestList = new ArrayList<>(5);

        diskTestList.add(new Disk(1));
        diskTestList.add(new Disk(2));
        diskTestList.add(new Disk(3));
        diskTestList.add(new Disk(4));
        diskTestList.add(new Disk(5));

        DiskStack stackTest = new DiskStack(5);

        for (Disk disk:diskTestList) {
            stackTest.push(disk);
            Assertions.assertEquals(stackTest.top(), disk);
        }

        for (int i=4; i != 0; i--) {
            Disk diskStack = (Disk)stackTest.pop();
            Assertions.assertEquals(diskStack, diskTestList.get(i));
        }
    }

    @Test
    @DisplayName("Stack size after including and removing disks from stack")
    void stackSize() {

        DiskStack stackTest = new DiskStack(5);

        for (int i=1; i<6; i++) {
            stackTest.push(new Disk(i));
            Assertions.assertEquals(stackTest.size(), i);
        }

        for (int i=5; i>0; i--) {
            stackTest.pop();
            Assertions.assertEquals(stackTest.size(), i-1);
        }
    }

    @Test
    @DisplayName("Pushing disk when stack is full")
    void includingDiskInAFullStack() {
        DiskStack stackTest = new DiskStack(2);

        stackTest.push(new Disk(1));
        stackTest.push(new Disk(2));

        Assertions.assertTrue(stackTest.push(new Disk(3)) == Disk.DISK_ZERO);
    }

    @Test
    @DisplayName("Removing disk from an empty stack")
    void removingDiskFromEmptyStack() {
        DiskStack stackTest = new DiskStack(2);

        stackTest.push(new Disk(1));
        stackTest.push(new Disk(2));

        stackTest.pop();
        stackTest.pop();

        Assertions.assertTrue(stackTest.pop() == Disk.DISK_ZERO);
    }
}