package martes.lairjunior.usjt.algesd.hanoi.event;

import martes.lairjunior.usjt.algesd.hanoi.Disk;
import martes.lairjunior.usjt.algesd.hanoi.Pin;

public class DiskSelectedEvent {

    private Disk _diskSelected;
    private Pin _sourcePin;

    public DiskSelectedEvent(Disk diskSelected, Pin sourcePin) {
        this._diskSelected = diskSelected;
        this._sourcePin = sourcePin;
    }

    public Disk getDiskSelected() { return this._diskSelected; }
    public Pin getSourcePin() { return this._sourcePin; }
}
