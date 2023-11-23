import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack {
    private ArrayList<Integer> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public void push(int item) {
        elements.add(item);
    }

    public int pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    public int peek() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
}

Stack stack = new Stack();
stack.push(1);
stack.push(2);
stack.push(3);

System.out.println(stack.pop()); // prints 3
System.out.println(stack.peek()); // prints 2
System.out.println(stack.isEmpty()); // prints false
System.out.println(stack.size()); // prints 2