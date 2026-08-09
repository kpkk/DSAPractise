package week7;


public class LinkedListImpl {

    class Node{
        int data;
        Node next;

        public Node(int ele){
            data=ele;
            next=null;
        }
    }

    public Node head;

    public LinkedListImpl(){
        head=null;
    }

    public void insertAtHead(int value){
        // create a node
        Node newNode = new Node(value);
        // link it with the elements
        newNode.next=head;
        head=newNode;
    }

    public void insertATTail(int value){
     // create new node
        Node newNode = new Node(value);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp= head; // duplicate
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    public void printList(Node head){
        Node temp= head;
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public void insertAtAnyPos(int ele, int pos){
        // create a node
        Node newNode = new Node(ele);
        if(pos==1){
            newNode.next=head;
            head=newNode;
        }
        Node temp= head;
        for(int i=2;i<pos && temp!=null; i++){
            temp=temp.next;
        }
        assert temp != null;
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public void deleteAtHead(){
        // if its a single valued list
        if(head.next==null)
            head=null;
        Node temp=head;
        head=head.next;
        temp=null;
    }

    public void deleteAtTail(){
        // if its a single valued list
        if(head.next==null)
            head=null;
        Node temp= head;
        while (temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }

    public void deleteAtPos(int pos){
        if(pos==1){
            Node temp=head;
            head=head.next;
            temp=null;
        }
        Node temp= head;
        for (int i=2;i<pos && temp!=null;i++){
            temp=temp.next;
        }
        assert temp != null;
        Node nodeToDelete=temp.next;
        temp.next=nodeToDelete.next;
    }


    public static void main(String[] args) {
        LinkedListImpl llimpl = new LinkedListImpl();
        llimpl.insertAtHead(5); // 5
        llimpl.insertAtHead(7); // 7 5
        llimpl.insertATTail(8); // 7 5 8
        llimpl.insertATTail(9); // 7 5 8 9
        llimpl.printList(llimpl.head);
        llimpl.insertAtAnyPos(6, 3); // 7 5 6 8 9
        System.out.println("-----------------------");
        llimpl.printList(llimpl.head);
        llimpl.insertAtAnyPos(10, 3);
        System.out.println("-----------------------");
        llimpl.printList(llimpl.head);
        llimpl.deleteAtHead();
        System.out.println("-----------------------");
        llimpl.printList(llimpl.head);
        llimpl.deleteAtTail();
        llimpl.deleteAtPos(3);
        System.out.println("-----------------------");
        llimpl.printList(llimpl.head);

    }

}
