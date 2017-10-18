package es4.stack;

/**
 * Created by affo on 18/10/17.
 */
public class TestDrive1 {
    public static void main(String[] args) {
        IntegerStack stack = new IntegerStack();

        System.out.println(stack.peek());
        stack.push(1);
        System.out.println(stack.peek());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.peek());
        stack.push(6);
        System.out.println(stack.peek());
        stack.push(7);
        System.out.println(stack.peek());
        stack.push(8);
        System.out.println(stack.peek());
        stack.push(9);
        System.out.println(stack.peek());
        stack.push(10);
        System.out.println(stack.peek());

        System.out.println("THE END");
    }
}
