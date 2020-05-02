package game.ui.command;

import com.martialdev.game.hanoitower.core.control.exception.InvalidMoveException;

public interface JogoCommand {
    void execute() throws InvalidMoveException;
}
