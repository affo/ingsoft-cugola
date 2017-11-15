package functional.remote.proposed_exercise;

import java.util.Stack;

/**
 * Created by affo on 15/11/17.
 */
public abstract class AbstractController {
    private Stack<Command> undoLog = new Stack<>();

    protected abstract Command doOn();

    protected abstract Command doOff();

    public Command on() {
        return () -> {
            doOn().execute();
            undoLog.push(doOff());
        };
    }

    public Command off() {
        return () -> {
            doOff().execute();
            undoLog.push(doOn());
        };
    }

    public Command undo() {
        return () -> undoLog.pop().execute();
    }
}
