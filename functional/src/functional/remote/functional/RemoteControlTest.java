package functional.remote.functional;

public class RemoteControlTest {
    public static void main(String[] args) {
        // the remote
        SimpleRemoteControl remote = new SimpleRemoteControl();
        // the things in your house
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();

        // command execution
        remote.setCommand(light::on);
        remote.buttonWasPressed();
        remote.setCommand(garageDoor::up);
        remote.buttonWasPressed();
    }
}
