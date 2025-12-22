// ? https://leetcode.com/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150

// ! 86. Partition List
// Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.
// Example 1:
// Input: head = [1,4,3,2,5,2], x = 3
// Output: [1,2,2,4,3,5]

public class PartitionList {

    // * Definition for singly-linked list.
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
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode sNode = new ListNode(0);
            ListNode gNode = new ListNode(0);

            ListNode tailSNode = sNode;
            ListNode tailGNode = gNode;

            ListNode curr = head;

            while (curr != null) {
                if (curr.val < x) {
                    tailSNode.next = curr;
                    tailSNode = curr;
                } else {
                    tailGNode.next = curr;
                    tailGNode = curr;
                }
                curr = curr.next;
            }
            tailGNode.next = null;
            tailSNode.next = gNode.next;
            return sNode.next;
        }
    }
    public static void main(String[] args) {
        // main method can be used for testing if needed
    }
}
