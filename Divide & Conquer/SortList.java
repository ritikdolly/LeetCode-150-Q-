
public class SortList {

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

    // approach 1 but it gives your time limit exceeded error
    // class Solution {
    // public ListNode sortList(ListNode head) {
    // if (head == null || head.next == null)
    // return head;

    // ListNode curr = head.next;
    // head.next = null;
    // ListNode prev = null;

    // while (curr != null) {
    // if (head.val >= curr.val) {
    // prev = curr;
    // curr = curr.next;
    // prev.next = head;
    // head = prev;
    // } else {
    // prev = curr;
    // curr = curr.next;
    // ListNode temp = head;
    // while (temp.next != null && temp.next.val < prev.val) {
    // temp = temp.next;
    // }
    // prev.next = temp.next;
    // temp.next = prev;
    // }
    // }
    // return head;
    // }
    // }

    // approach 2 using merge sort
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            // find mid
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;

            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            prev.next = null; // split the list into two halves

            ListNode left = sortList(head);
            ListNode right = sortList(slow);

            return merge(left, right);
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }

            if (l1 != null) {
                tail.next = l1;
            } else {
                tail.next = l2;
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        //write a test case here if needed
    }

}
