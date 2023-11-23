import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        // Inserting elements
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(30);
        priorityQueue.add(40);
        priorityQueue.add(50);

        // Displaying the priority queue elements
        System.out.println("The elements of the priority queue are: " + priorityQueue);

        // Removing elements
        priorityQueue.poll();
        priorityQueue.poll();

        // Displaying the priority queue elements after removal
        System.out.println("After removing 2 elements, the priority queue elements are: " + priorityQueue);
    }
}