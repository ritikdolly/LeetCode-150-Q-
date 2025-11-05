// ?https://leetcode.com/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150

//! Given the head of a linked list, rotate the list to the right by k places.

//* Input: head = [1,2,3,4,5], k = 2
//* Output: [4,5,1,2,3]



public class RotateRightList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length and last node
        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }

        // Step 2: Make it circular
        curr.next = head;

        // Step 3: Find the point to break the circle
        k = k % len;
        int stepToHead = len - k;
        ListNode newTail = head;

        for (int i = 1; i < stepToHead; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Helper function to print list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {
        // Creating Linked List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int k = 2;
        ListNode rotated = rotateRight(head, k);

        System.out.println("Rotated List by " + k + ":");
        printList(rotated);
    }
}
