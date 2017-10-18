package es4.stack;

/**
 * Created by affo on 18/10/17.
 */
public class TestDrive2 {
    public static void main(String[] args) {
        IntegerStackWException stack = new IntegerStackWException();

        try {
            try {
                System.out.println(stack.peek());
            } catch (IntegerStackWException.EmptyException e) {
                System.out.println("Is empty, cannot peek, never mind, continue...");
            }

            stack.push(1);

            try {
                // now I should be able to peek
                System.out.println(stack.peek());
            } catch (IntegerStackWException.EmptyException e) {
                System.out.println("If you see this nothing is true, anymore!!");
            }

            stack.push(2);
            stack.push(3);
            stack.push(4);
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            //System.out.println(stack.pop()); // Exception
            stack.push(5);
            stack.push(6);
            stack.push(7);
            stack.push(8);
            stack.push(9);
            //stack.push(10); // Exception

            System.out.println("THE END");
        } catch (IntegerStackWException.FullException fe) {
            System.out.println(fe.getMessage() + " - " + fe.getCapacity() + " - " + fe.getElements());
        } catch (IntegerStackWException.EmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}
