// ? https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=study-plan-v2&envId=top-interview-150

// ! 82. Remove Duplicates from Sorted List II

// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
// Example 1:
// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]

public class RemoveDuplicatesfromSortedListII {

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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode curr = head;
            ListNode prev = dummy;
            while (curr != null) {
                if (curr.next != null && curr.next.val == curr.val) {
                    int depVal = curr.val;
                    while (curr != null && curr.val == depVal) {
                        curr = curr.next;
                    }
                    prev.next = curr;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            return dummy.next;

        }
    }

}
