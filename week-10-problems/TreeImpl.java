package week10;

import java.util.ArrayList;
import java.util.List;

class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    public class TreeImpl{

    Node root;

    public TreeImpl(int val){
        root = new Node(val);
        root.left=null;
        root.right=null;
    }

    public int countNodes(Node root){
        if(root==null) return 0;
        return 1+ countNodes(root.left)+countNodes(root.right);
    }

    public int leafNodes(Node root){
        if(root.left==null && root.right==null) return 1;
        return leafNodes(root.left)+leafNodes(root.right);
    }

    public int sumOfNodes(Node root){
        if(root==null) return 0;
        return root.data+ sumOfNodes(root.left)+sumOfNodes(root.right);
    }

    public void preOrderTraversal(Node root){
        List<Integer> list= new ArrayList<>();
        preOrder(root, list);
        System.out.println(list);
    }

    public void postOrderTraversal(Node root){
        List<Integer> list= new ArrayList<>();
        postOrder(root, list);
        System.out.println(list);
    }

    public void inOrderTraversal(Node root){
        List<Integer> list= new ArrayList<>();
        inOrder(root, list);
        System.out.println(list);
    }

    public void preOrder(Node root, List<Integer> list){
        if (root==null) return;
        list.add(root.data);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public void postOrder(Node root, List<Integer> list){
        if (root==null) return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.data);
    }

    public void inOrder(Node root, List<Integer> list){
        if (root==null) return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static void main(String[] args) {
        TreeImpl tree = new TreeImpl(1);
        tree.root.left= new Node(2);
        tree.root.right=new Node(3);

        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);

        tree.root.right.left=new Node(6);
        tree.root.right.right=new Node(7);

        int i = tree.countNodes(tree.root);
        System.out.println(i);

        int j = tree.leafNodes(tree.root);
        System.out.println(j);

        int sum = tree.sumOfNodes(tree.root);
        System.out.println(sum);
        tree.preOrderTraversal(tree.root);
        tree.postOrderTraversal(tree.root);
        tree.inOrderTraversal(tree.root);
    }
}
