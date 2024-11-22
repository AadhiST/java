import java.util.*;
class StackExample {
    private LinkedList<Integer> stack = new LinkedList<>();
    public void push(int value) {
        stack.addFirst(value);
    }
    public int pop() {
        return stack.isEmpty() ? -1 : stack.removeFirst();
    }
    public int peek() {
        return stack.isEmpty() ? -1 : stack.getFirst();
    }
}
class QueueExample {
    private LinkedList<Integer> queue = new LinkedList<>();
    public void enqueue(int value) {
        queue.addLast(value);
    }
    public int dequeue() {
        return queue.isEmpty() ? -1 : queue.removeFirst();
    }
    public int peek() {
        return queue.isEmpty() ? -1 : queue.getFirst();
    }
}
public class sq {
    public static void main(String[] args) {
        // Stack operations
        StackExample stack = new StackExample();
        stack.push(10);
        stack.push(20);
        System.out.println("Stack Peek: " + stack.peek());
        System.out.println("Stack Pop: " + stack.pop());
        // Queue operations
        QueueExample queue = new QueueExample();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("Queue Peek: " + queue.peek());
        System.out.println("Queue Dequeue: " + queue.dequeue());
    }
}
