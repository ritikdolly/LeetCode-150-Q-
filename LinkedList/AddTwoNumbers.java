// ? https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150

//!2. Add Two Numbers
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8] 

public class AddTwoNumbers {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Solution class
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode dummy = new ListNode(0);   // dummy node
            ListNode curr = dummy;              // pointer to build new list
            int carry = 0;                      // carry starts from 0

            // loop until all nodes & carry are processed
            while (l1 != null || l2 != null || carry == 1) {

                int sum = 0;

                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                sum += carry;     // include previous carry
                carry = sum / 10; // update carry

                ListNode node = new ListNode(sum % 10); // create new digit node
                curr.next = node;  // attach to list
                curr = curr.next;  // move pointer
            }

            return dummy.next; // skip dummy
        }
    }

    // Main method (psvm)
    public static void main(String[] args) {

        // creating first number: 2 -> 4 -> 3  (342)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // creating second number: 5 -> 6 -> 4 (465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);

        // printing result
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print(" -> ");
            result = result.next;
        }
    }
}
