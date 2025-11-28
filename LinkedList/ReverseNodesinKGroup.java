// ? https://leetcode.com/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-interview-150

// ! Reverse Nodes in k-Group
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.
// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]


public class ReverseNodesinKGroup {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {

        private ListNode getKthNode(ListNode curr, int k) {
            while (curr != null && k > 1) {
                curr = curr.next;
                k--;
            }
            return curr;
        }

        public ListNode reverseKGroup(ListNode head, int k) {

            if (head == null || k == 1)
                return head;

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prevGroupEnd = dummy;
            ListNode curr = head;

            while (true) {

                ListNode kth = getKthNode(curr, k);
                if (kth == null)
                    break; // no enough nodes

                ListNode nextGroupStart = kth.next;

                // reverse nodes from curr to kth
                ListNode prev = null;
                ListNode temp = curr;
                while (temp != nextGroupStart) {
                    ListNode next = temp.next;
                    temp.next = prev;
                    prev = temp;
                    temp = next;
                }

                prevGroupEnd.next = kth;
                curr.next = nextGroupStart;

                prevGroupEnd = curr;
                curr = nextGroupStart;
            }

            return dummy.next;
        }
    }

    // Print function for checking result
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ReverseNodesinKGroup obj = new ReverseNodesinKGroup();
        ReverseNodesinKGroup.Solution sol = obj.new Solution();

        // List: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = obj.new ListNode(1);
        head.next = obj.new ListNode(2);
        head.next.next = obj.new ListNode(3);
        head.next.next.next = obj.new ListNode(4);
        head.next.next.next.next = obj.new ListNode(5);
        head.next.next.next.next.next = obj.new ListNode(6);

        System.out.println("Original List:");
        obj.printList(head);

        int k = 3;

        head = sol.reverseKGroup(head, k);

        System.out.println("After reverse in groups of " + k + ":");
        obj.printList(head);
    }
}
