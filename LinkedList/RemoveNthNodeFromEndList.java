// ? https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-interview-150

// ! 19 Remove Nth Node From End of List
// Given the head of a linked list, remove the nth node from the end of the list and return its head.
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

public class RemoveNthNodeFromEndList {

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || n <= 0) {
                return head;
            }
            ListNode fast = head;
            ListNode slow = head;
            for (int i = 0; i < n; i++) {
                if (fast == null) {
                    return head;
                }
                fast = fast.next;
            }
            if (fast == null) {
                return head.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }
   
    public static void main(String[] args) {
        //add code
    }

}
