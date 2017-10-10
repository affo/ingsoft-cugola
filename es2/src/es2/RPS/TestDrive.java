package es2.RPS;

/**
 * Created by affo on 10/10/17.
 */
public class TestDrive {
    public static void main(String[] args) {
        Choice first = Choice.random();
        Choice second = Choice.random();

        System.out.println(first + " VS " + second + ": " +
                first.result(second)
        );
    }
}
