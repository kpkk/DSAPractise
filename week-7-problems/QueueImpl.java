package week7;

import java.util.Queue;

public class QueueImpl {

    int[] queue;
    int front;
    int rear;

    public QueueImpl(int size) {
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean enque(int ele) {
        if (rear >= queue.length - 1){
            System.out.println("Queue is full");
            return false;
        }
        queue[(++rear%queue.length)] = ele;
        if(front==-1) front=0;
        return true;
    }

    public int dequeue() {
        if(front==-1) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int number= queue[front];
        queue[front]=0;
        front=(front+1)%queue.length;
        return number;
    }

    public int size() {
        return rear+1-front;
    }

    public static void main(String[] args) {
        QueueImpl q = new QueueImpl(5);
        q.enque(5);
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);
        q.enque(7);
        System.out.println(q.size());
        q.dequeue();
        System.out.println(q.size());

    }
}
