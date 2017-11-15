package functional.remote.proposed_exercise;

/**
 * The invoker
 */
public class RemoteControl {
    Row[] slots;

    public RemoteControl(int noSlots) {
        slots = new Row[noSlots];
    }

    public void setCommand(int pos, AbstractController controller) {
        validatePos(pos);
        Row row = new Row();
        row.on = controller.on();
        row.off = controller.off();
        row.undo = controller.undo();
        slots[pos] = row;
    }

    private void validatePos(int pos) {
        if (pos < 0 || pos >= slots.length) {
            throw new IllegalArgumentException("Button out of bounds: " + pos);
        }
    }

    public void onButtonPressed(int pos) {
        validatePos(pos);
        slots[pos].on.execute();
    }

    public void offButtonPressed(int pos) {
        validatePos(pos);
        slots[pos].off.execute();
    }

    public void undoButtonPressed(int pos) {
        validatePos(pos);
        slots[pos].undo.execute();
    }

    private static class Row {
        Command on, off, undo;
    }
}
