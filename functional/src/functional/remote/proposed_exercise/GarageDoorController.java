package functional.remote.proposed_exercise;

/**
 * Created by affo on 15/11/17.
 */
public class GarageDoorController extends AbstractController {
    private GarageDoor door;

    public GarageDoorController(GarageDoor door) {
        this.door = door;
    }

    @Override
    protected Command doOn() {
        return door::up;
    }

    @Override
    protected Command doOff() {
        return door::down;
    }
}
