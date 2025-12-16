// ? https://leetcode.com/problems/merge-k-sorted-lists/?envType=study-plan-v2&envId=top-interview-150

// //! 23. Merge k Sorted Lists
// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]

import java.util.PriorityQueue;

public class MergekSortedLists {

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
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    minHeap.offer(lists[i]);
                }
            }

            ListNode dummy = new ListNode(-1);
            ListNode temp = dummy;
            while (!minHeap.isEmpty()) {
                ListNode currNode = minHeap.poll();
                temp.next = currNode;
                temp = temp.next;
                if (currNode.next != null) {
                    minHeap.offer(currNode.next);
                }
            }
            return dummy.next;

        }
    }
    public static void main(String[] args) {
        // write your own test cases
    }

}