//* 117. Populating Next Right Pointers in Each Node II

// ? https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/?envType=study-plan-v2&envId=top-interview-150
//! Given a binary tree
//! struct Node {
//!   int val;
//!   Node *left;
//!   Node *right;
//!   Node *next;
//! }
//! Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

//! Initially, all next pointers are set to NULL.


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        Node curr = root;

        while (curr != null) {
            Node dummy = new Node(0);
            Node tail = dummy;

            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                curr = curr.next;
            }
            curr = dummy.next; // move to next level
        }
        return root;
    }
}

public class PopulatingNext {
    public static void main(String[] args) {

        // Creating a sample binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        Solution sol = new Solution();
        sol.connect(root);

        // Printing level by level using next pointers
        printLevels(root);
    }

    static void printLevels(Node root) {
        while (root != null) {
            Node curr = root;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }
            System.out.println("null");

            // move to the first node of the next level
            if (root.left != null) root = root.left;
            else if (root.right != null) root = root.right;
            else root = findNext(root.next);
        }
    }

    static Node findNext(Node node) {
        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next;
        }
        return null;
    }
}



// ? by createing extra space using queue 
// class Solution {
//     public Node connect(Node root) {
//         if(root == null){
//             return null;
//         }        
//         Queue<Node> q=new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int level=q.size();
//             for(int i=0;i<level;i++){
//                 Node node=q.poll();
//                 if(level-1 >i){
//                     node.next=q.peek();
//                 }else{
//                     node.next=null;
//                 }

//                 if(node.left != null){
//                     q.add(node.left);
//                 }

//                 if(node.right != null){
//                     q.add(node.right);
//                 }
//             }
//         }
//         return root;
//     }
// }