package week10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    // https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    public List<List<Integer>> levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if(root==null) return ans;
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int level = queue.size();
            for (int i=0;i<level;i++){
                Node poll = queue.poll();
                if(poll.left!=null) queue.offer(poll.left);
                if(poll.right!=null) queue.offer(poll.right);
                list.add(poll.data);
            }
            ans.add(list);
        }
        return ans;
    }

    // https://leetcode.com/problems/same-tree/description/
    public boolean isSameTree(Node p, Node q) {
            if(p==null && q==null) return true;
            if(p==null || q==null || p.data!=q.data) return false;
            boolean left=isSameTree(p.left, q.left);
            boolean right=isSameTree(p.right, q.right);
            return left && right;

    }

    // https://leetcode.com/problems/maximum-depth-of-binary-tree/
    public int maxDepth(Node root) {
            if(root==null) return 0;
            int left= maxDepth(root.left);
            int right= maxDepth(root.right);
            return 1+ Math.max(left, right);
    }

    // https://leetcode.com/problems/path-sum/
        public boolean hasPathSum(Node root, int targetSum) {
            return dfs(root, targetSum);
        }

        public boolean dfs(Node root, int target){
            if(root==null) return false;
            if(root.left==null && root.right==null) return target-root.data==0;
            boolean left = dfs(root.left, target-root.data);
            boolean right = dfs(root.right, target-root.data);
            return left || right;
        }

        //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

        public Node lowestCommonAncestor(Node root, Node p, Node q) {
            if(root==null || root==p || root==q) return root;
            Node left = lowestCommonAncestor(root.left, p, q);
            Node right = lowestCommonAncestor(root.right, p, q);
            if(left==null)
                return right;
            else if(right==null)
                return left;
            else return root;
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

        List<List<Integer>> list = tree.levelOrderTraversal(tree.root);
        System.out.println(list);
    }
}
