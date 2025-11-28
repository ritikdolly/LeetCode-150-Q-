// ? https://leetcode.com/problems/reverse-linked-list-ii/?envType=study-plan-v2&envId=top-interview-150

// ! Reverse Linked List II
// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]




public class ReverseLinkedListII {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode curNode = head;
            ListNode leftPrev = dummy;

            // Move leftPrev and curNode to their starting points
            for (int i = 0; i < left - 1; i++) {
                leftPrev = leftPrev.next;
                curNode = curNode.next;
            }

            ListNode subHeadNode = curNode;
            ListNode preNode = null;

            // Reverse from left to right
            for (int i = left; i <= right; i++) {
                ListNode nextNode = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = nextNode;
            }

            // Connect the reversed part
            leftPrev.next = preNode;
            subHeadNode.next = curNode;

            return dummy.next;
        }
    }

    // helper function to print list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ReverseLinkedListII obj = new ReverseLinkedListII();
        ReverseLinkedListII.Solution sol = obj.new Solution();

        // Creating LinkedList: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = obj.new ListNode(1);
        head.next = obj.new ListNode(2);
        head.next.next = obj.new ListNode(3);
        head.next.next.next = obj.new ListNode(4);
        head.next.next.next.next = obj.new ListNode(5);

        System.out.println("Original List:");
        obj.printList(head);

        // Reverse from position 2 to 4 → result: 1 4 3 2 5
        head = sol.reverseBetween(head, 2, 4);

        System.out.println("After Reverse:");
        obj.printList(head);
    }
}
