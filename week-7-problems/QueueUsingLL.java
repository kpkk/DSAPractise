package week7;

public class QueueUsingLL {

    class Node{
        int data;
        Node next;

        public Node(int value){
            data=value;
            next=null;
        }
    }

    public Node front;
    public Node rear;
    int count;

    public QueueUsingLL(){
        front=null;
        rear=null;
        count=0;
    }

    public void addNode(int ele){
        Node newNode = new Node(ele);
        if(front==null){
            newNode.next=rear;
            front=newNode;
            rear=newNode;
            count++;
            return;
        }
        rear.next=newNode;
        rear=newNode;
        count++;
    }

    public void printList(Node node){
        Node temp= node;
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public void enqueue(int ele){
        addNode(ele);
    }

    public void dequeue(){
        if(front==null) {
            System.out.println("Queue is empty");
            return;
        }
        front = front.next;
        if(front==null) rear=null;
        count--;
    }

    public int getFront(){
        if(front==null) return -1;
        return front.data;
    }
    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return front==null && rear==null;
    }

    public static void main(String[] args) {
        QueueUsingLL qll = new QueueUsingLL();
//        System.out.println("queue is empty"+qll.isEmpty());
//        qll.enqueue(5);
//        qll.enqueue(6);
//        qll.enqueue(7);
//        System.out.println("-------------------");
//        qll.printList(qll.front);
//        qll.dequeue();
//        System.out.println("-------------------");
//        qll.printList(qll.front);
//        System.out.println("-------------------");
//        System.out.println(qll.getFront());
//        System.out.println("-------------------");
//        System.out.println(qll.size());
        System.out.println("queue is empty"+qll.isEmpty());
        qll.enqueue(0);
        qll.dequeue();
        System.out.println(qll.size());
        System.out.println("queue is empty"+qll.isEmpty());
        qll.enqueue(13);
        qll.dequeue();
        qll.enqueue(2);
        System.out.println("queue is empty"+qll.isEmpty());


    }
}
//9
//        4
//        1 0
//        2
//        5
//
//        4
//        1 13
//        2
//        1 2
//        4