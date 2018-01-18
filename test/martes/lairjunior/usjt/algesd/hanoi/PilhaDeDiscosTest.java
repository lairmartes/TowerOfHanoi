package martes.lairjunior.usjt.algesd.hanoi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PilhaDeDiscosTest {

    @Test
    @DisplayName("Initial stack must start with zero disks")
    void initializingStack() {

        int testQtty = 3;
        PilhaDeDiscos stackTest = new PilhaDeDiscos(testQtty);

        Assertions.assertEquals(stackTest.size(), 0); // no matter stack size, stack has zero disks
    }

    @Test
    @DisplayName("Test removing disks in a stack with higher capacity")
    void removingDisk() {

        int testQtty = 3;
        PilhaDeDiscos stackTest = new PilhaDeDiscos(testQtty);

        stackTest.pop();
        Assertions.assertEquals(stackTest.size(), 0); /* the capacity of the stack doesn't change
                                                                since there's no disks in stack */

        stackTest.pop();
        Assertions.assertEquals(stackTest.size(), 0);
    }

    @Test
    @DisplayName("Including disks in a stack with higher capacity")
    void addingDisk() {

        Disco diskTest = new Disco(3);
        int testQtty = 5; // stack with higher capacity

        PilhaDeDiscos stackTest = new PilhaDeDiscos(testQtty);

        stackTest.push(diskTest);
        Assertions.assertEquals(stackTest.size(), 1);

        stackTest.push(diskTest);
        Assertions.assertEquals(stackTest.size(), 2);
    }

    @Test
    @DisplayName("Push and pop content sequence")
    void sequencePushAndPop() {
        List<Disco> diskTestList = new ArrayList<>(5);

        diskTestList.add(new Disco(1));
        diskTestList.add(new Disco(2));
        diskTestList.add(new Disco(3));
        diskTestList.add(new Disco(4));
        diskTestList.add(new Disco(5));

        PilhaDeDiscos stackTest = new PilhaDeDiscos(5);

        for (Disco disk:diskTestList) {
            stackTest.push(disk);
            Assertions.assertEquals(stackTest.top(), disk);
        }

        for (int i=4; i != 0; i--) {
            Disco diskStack = (Disco)stackTest.pop();
            Assertions.assertEquals(diskStack, diskTestList.get(i));
        }
    }

    @Test
    @DisplayName("Stack size after including and removing disks from stack")
    void stackSize() {

        PilhaDeDiscos stackTest = new PilhaDeDiscos(5);

        for (int i=1; i<6; i++) {
            stackTest.push(new Disco(i));
            Assertions.assertEquals(stackTest.size(), i);
        }

        for (int i=5; i>0; i--) {
            stackTest.pop();
            Assertions.assertEquals(stackTest.size(), i-1);
        }
    }

}