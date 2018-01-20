package martes.lairjunior.usjt.algesd.hanoi.event;

public interface HanoiTowerListener {

    void hanoiTowerEvent(MoveEvent event);
    void hanoiTowerEvent(GameOverEvent event);
    void hanoiTowerEvent(DiskSelectedEvent event);
}
