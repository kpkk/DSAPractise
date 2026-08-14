package week7;

public class QueueImplementation {

    int[] queue;
    int front;
    int rear;

    public QueueImplementation(int size) {
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(int ele) {
        if (rear >= queue.length - 1) System.out.println("No element can be inserted, queue is already full");
        queue[++rear] = ele;
        if (front == -1) front++;
    }

    public int deque() {
        if (front == -1) throw new RuntimeException("queue is empty and no element can be dequeued");
        int number = queue[front];
        queue[front++] = 0;
       // front=(front+1)%queue.length; -> this is for circular queue
        return number;
    }

    public int size() {
        return rear;
    }

}
