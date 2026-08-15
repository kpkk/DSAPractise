package week8;

public class AddtwoNumbers {
    class Node{
        int data;
        Node next;

        public Node(int ele){
            data=ele;
            next=null;
        }
    }

    public Node head;

    public AddtwoNumbers(){
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

    public Node addTwoNumbers(Node n1, Node n2){
        Node ans = new Node(0);
        Node temp= ans;
        int carry=0;
        while (n1!=null || n2!=null || carry==1){
            int sum=0;
            if(n1!=null){
                sum+=n1.data;
                n1=n1.next;
            }
            if(n2!=null){
                sum+=n2.data;
                n2=n2.next;
            }
            sum+=carry;
            carry= sum/10;
            temp.next= new Node(sum%10);
            temp=temp.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        AddtwoNumbers rrl = new AddtwoNumbers();
        rrl.insertAtHead(2);
        rrl.insertAtHead(4);
        rrl.insertAtHead(3);
        rrl.printList(rrl.head);
        System.out.println("-----------------");
        AddtwoNumbers rrl1 = new AddtwoNumbers();
        rrl1.insertAtHead(5);
        rrl1.insertAtHead(8);
        rrl1.insertAtHead(4);
        System.out.println("#################");
        Node node = rrl1.addTwoNumbers(rrl.head, rrl1.head);
        rrl.printList(node);
    }
}
