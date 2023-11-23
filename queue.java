import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();

        // Inserting elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Displaying the queue elements
        System.out.println("The elements of the queue are: " + queue);

        // Removing elements
        queue.dequeue();
        queue.dequeue();

        // Displaying the queue elements after removal
        System.out.println("After removing 2 elements, the queue elements are: " + queue);
    }
}

class Queue {
    LinkedList<Integer> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    // Adds an element at the end of the queue
    public void enqueue(int element) {
        queue.addLast(element);
    }

    // Removes an element from the front of the queue
    public void dequeue() {
        if (!queue.isEmpty()) {
            queue.removeFirst();
        } else {
            System.out.println("The queue is empty.");
        }
    }

    // Returns the front element of the queue
    public int front() {
        if (!queue.isEmpty()) {
            return queue.getFirst();
        } else {
            System.out.println("The queue is empty.");
            return -1;
        }
    }

    // Returns the size of the queue
    public int size() {
        return queue.size();
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}