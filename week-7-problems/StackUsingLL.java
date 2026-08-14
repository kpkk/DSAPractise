package week7;

public class StackUsingLL {

    class Node{
        int data;
        Node next;

        public Node(int value){
            data=value;
            next=null;
        }
    }

    public Node head;
    int count;

    public StackUsingLL(){
        head=null;
        count=0;
    }

    public void addNodeAtHead(int ele){
        Node newNode = new Node(ele);
        newNode.next=head;
        head=newNode;
        count++;
    }

    public void printList(Node node){
        Node temp= node;
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public void push(int ele){
        addNodeAtHead(ele);
    }
    public int peek(){
        return head.data;
    }

    public int pop(){
        Node temp= head;
        head=head.next;
        count--;
        return temp.data;
    }
    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public static void main(String[] args) {
        StackUsingLL ssl= new StackUsingLL();
        System.out.println(ssl.isEmpty());
        ssl.push(5);
        ssl.push(6);
        ssl.push(7);
        System.out.println(ssl.size());
        System.out.println("----------------------");
        ssl.printList(ssl.head);
        ssl.pop();
        System.out.println("----------------------");
        System.out.println(ssl.size());
        System.out.println(ssl.isEmpty());
        System.out.println("----------------------");
        ssl.printList(ssl.head);


    }
}
