/*
 * Criado em 26/09/2005
 *
 * Para alterar o gabarito para este arquivo gerado vá para
 * Janela&gt;Preferências&gt;Java&gt;Geração de Códigos&gt;Código e Comentários
 */
package martes.lairjunior.usjt.algesd.hanoi;

import martes.lairjunior.usjt.algesd.hanoi.exception.InvalidMoveException;

/**
 * @author Lair Martes Junior - 2CCPN - USJT
 */
public class Pin {
    private DiskStack diskStack;

    public Pin(int howManyDisks) {

        diskStack = new DiskStack(howManyDisks);
    }

    public void add(Disk diskToBeStacked) throws InvalidMoveException {
        if (diskToBeStacked.getSize() == 0)
            throw new InvalidMoveException("You can't include a disk with zero length.");
        if (diskStack.size() == 0) {
            diskStack.push(diskToBeStacked);
            return;
        }
        if (diskStack.top().compareTo(diskToBeStacked) < 1) {
            throw new InvalidMoveException(
                    "This pin can't receive " + diskToBeStacked + "since it's greater than " + diskStack.top());
        } else diskStack.push(diskToBeStacked);
    }

    public Disk removeDisk() throws InvalidMoveException {
        if (diskStack.size() == 0) {
            throw new InvalidMoveException("This pin have no disks");
        } else {
            return diskStack.pop();
        }
    }

    public Disk[] getDisks() {
        return diskStack.content();
    }

    public void reset(int howManyDisks) {
        diskStack.reset(howManyDisks);
    }

    protected int getStackSize() {
        return diskStack.size();
    }
}
