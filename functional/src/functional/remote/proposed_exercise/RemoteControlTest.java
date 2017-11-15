package functional.remote.proposed_exercise;

public class RemoteControlTest {
    public static void main(String[] args) {
        // the remote
        RemoteControl remote = new RemoteControl(10);
        // the things in your house
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        Fan fan = new Fan();

        // command execution
        remote.setCommand(0, new LightController(light));
        remote.setCommand(1, new GarageDoorController(garageDoor));
        remote.setCommand(2, new FanController(fan));
        remote.onButtonPressed(0);
        remote.undoButtonPressed(0);
        remote.offButtonPressed(0);
        remote.undoButtonPressed(0);

        remote.onButtonPressed(1);
        remote.undoButtonPressed(1);
        remote.onButtonPressed(1);
        remote.undoButtonPressed(1);

        remote.onButtonPressed(2);
        remote.onButtonPressed(2);
        remote.onButtonPressed(2);
        remote.undoButtonPressed(2);
        remote.offButtonPressed(2);
        remote.undoButtonPressed(2);
    }
}
