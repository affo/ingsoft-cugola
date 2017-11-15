package functional.remote.proposed_exercise;

/**
 * Created by affo on 15/11/17.
 */
public class FanController extends AbstractController {
    private Fan fan;

    public FanController(Fan fan) {
        this.fan = fan;
    }

    @Override
    protected Command doOn() {
        return fan::increaseSpeed;
    }

    @Override
    protected Command doOff() {
        return fan::decreaseSpeed;
    }
}
