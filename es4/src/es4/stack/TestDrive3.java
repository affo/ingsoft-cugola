package es4.stack;

import es4.exceptions.OutOfBoundsException;

/**
 * Created by affo on 18/10/17.
 */
public class TestDrive3 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        try {
            try {
                System.out.println(stack.peek());
            } catch (OutOfBoundsException e) {
                System.out.println("Is empty, cannot peek, never mind, continue...");
            }

            stack.push("foo");

            try {
                // now I should be able to peek
                System.out.println(stack.peek());
            } catch (OutOfBoundsException e) {
                System.out.println("If you see this, nothing is true, anymore!!");
            }

            stack.push("bar");
            stack.push("buz");
            stack.push("boo");
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            //System.out.println(stack.pop()); // Exception
            stack.push("foxtrot");
            stack.push("uniform");
            stack.push("charlie");
            stack.push("kilo");
            stack.push("alpha");
            //stack.push("exception"); // Exception

            System.out.println("THE END");
        } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
