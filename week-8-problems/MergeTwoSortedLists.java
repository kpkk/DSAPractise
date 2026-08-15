package week8;

public class MergeTwoSortedLists {

    class Node{
        int data;
        Node next;

        public Node(){
            data=0;
            next=null;
        }

        public Node(int ele){
            data=ele;
            next=null;
        }
    }

    public Node head;

    public MergeTwoSortedLists(){
        head=null;
    }

    public void insertAtHead(int value){
        // create a node
        Node newNode = new Node(value);
        // link it with the elements
        newNode.next=head;
        head=newNode;
    }

    public void printList(Node head){
        Node temp= head;
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public Node mergeLinkedList(Node n1, Node n2){
        Node ans= new Node(); //0 1 2 3 4
        Node temp=ans;
        while (n1!=null && n2!=null){
            if(n1.data<=n2.data){
                temp.next=n1;
                n1=n1.next;
            }else {
                temp.next=n2;
                n2=n2.next;
            }
            temp=temp.next;
        }
        if(n1!=null){
            temp.next=n1;
        }
        else
            temp.next=n2;

        return ans.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists rrl = new MergeTwoSortedLists();
        rrl.insertAtHead(4);
        rrl.insertAtHead(2);
        rrl.insertAtHead(1);
        rrl.printList(rrl.head);
        System.out.println("-----------------");
        MergeTwoSortedLists rrl1 = new MergeTwoSortedLists();
        rrl1.insertAtHead(4);
        rrl1.insertAtHead(3);
        rrl1.insertAtHead(1);
        Node node = rrl.mergeLinkedList(rrl.head, rrl1.head);
        System.out.println("#################");
        rrl.printList(node);

    }
}
