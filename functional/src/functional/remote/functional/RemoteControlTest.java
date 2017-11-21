package functional.remote.functional;

public class RemoteControlTest {
    public static void main(String[] args) {
        // the remote
        SimpleRemoteControl remote = new SimpleRemoteControl();
        // the things in your house
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();

        Command lightOnCommand = () -> light.on();
        Command garageDoorOpenCommand = () -> garageDoor.up();

        // command execution
        remote.setCommand(lightOnCommand);
        remote.buttonWasPressed();
        remote.setCommand(garageDoorOpenCommand);
        remote.buttonWasPressed();
    }
}
