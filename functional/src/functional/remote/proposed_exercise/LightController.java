package functional.remote.proposed_exercise;

/**
 * Created by affo on 15/11/17.
 */
public class LightController extends AbstractController {
    private Light receiver;

    public LightController(Light receiver) {
        this.receiver = receiver;
    }

    @Override
    public Command doOn() {
        return receiver::on;
    }

    @Override
    public Command doOff() {
        return receiver::off;
    }
}
