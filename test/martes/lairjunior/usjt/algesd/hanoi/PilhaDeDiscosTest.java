package martes.lairjunior.usjt.algesd.hanoi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PilhaDeDiscosTest {

    @Test
    @DisplayName("Initial stack")
    void initializingStack() {

        int testQtty = 3;
        PilhaDeDiscos stackTest = new PilhaDeDiscos(testQtty);

        Assertions.assertEquals(stackTest.size(), testQtty);
    }

    @Test
    @DisplayName("Test removing disk")
    void removingDisk() {

        int testQtty = 3;
        PilhaDeDiscos stackTest = new PilhaDeDiscos(testQtty);

        stackTest.pop();
        Assertions.assertEquals(stackTest.size(), (testQtty - 1));

        stackTest.pop();
        Assertions.assertEquals(stackTest.size(), (testQtty - 2));
    }

    @Test
    @DisplayName("Test including disk")
    void addingDisk() {

        Disco diskTest = new Disco(3);
        int testQtty = 3;

        PilhaDeDiscos stackTest = new PilhaDeDiscos(testQtty);

        stackTest.push(diskTest);
        Assertions.assertEquals(stackTest.size(), (testQtty + 1));

        stackTest.push(diskTest);
        Assertions.assertEquals(stackTest.size(), testQtty + 2);
    }

}