// ? https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/?envType=study-plan-v2&envId=top-interview-150

//! 117. Populating Next Right Pointers in Each Node II
// Given a binary tree
// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
// Initially, all next pointers are set to NULL.
 
// Example 1:
// Input: root = [1,2,3,4,5,null,7]
// Output: [1,#,2,3,#,4,5,7,#]

public class PopulatingNextRightPointersinEachNodeII {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }

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
                curr = dummy.next;
            }
            return root;

        }
    }

    public static void main(String[] args) {
        // write your own test cases
    }
    
}