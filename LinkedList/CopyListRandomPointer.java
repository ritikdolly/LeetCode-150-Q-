// ? https://leetcode.com/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-interview-150

// ! Copy List with Random Pointer

// A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
// Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
// For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
// Return the head of the copied linked list.
// The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
// Your code will only be given the head of the original linked list.

// Example 1:
// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]


public class CopyListRandomPointer {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null)
                return null;

            Node temp = head;

            while (temp != null) {
                Node copyNode = new Node(temp.val);
                copyNode.next = temp.next;
                temp.next = copyNode;
                temp = temp.next.next;
            }

            temp = head;
            while (temp != null) {
                Node copyNode = temp.next;
                if (temp.random != null) {
                    copyNode.random = temp.random.next;
                } else {
                    copyNode.random = null;
                }
                temp = temp.next.next;
            }

            Node dummyNode = new Node(-1);
            Node res = dummyNode;
            temp = head;
            while (temp != null) {
                res.next = temp.next;
                res = res.next;

                temp.next = temp.next.next;
                temp = temp.next;
            }
            return dummyNode.next;

        }
    }

    public static void main(String[] args) {
        CopyListRandomPointer outer = new CopyListRandomPointer();
        Solution solution = outer.new Solution();

        // Test Case
        Node node1 = outer.new Node(7);
        Node node2 = outer.new Node(13);
        Node node3 = outer.new Node(11);
        Node node4 = outer.new Node(10);
        Node node5 = outer.new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node copiedListHead = solution.copyRandomList(node1);

        // Print the copied list to verify
        Node temp = copiedListHead;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.println("Node Val: " + temp.val + ", Random Val: " + randomVal);
            temp = temp.next;
        }
    }
}
