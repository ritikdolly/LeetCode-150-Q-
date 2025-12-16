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

    // Using Merge Two Sorted Lists repeatedly - O(NK) time complexity
    // class Solution {
    // public ListNode mergeKLists(ListNode[] lists) {
    // if (lists == null)
    // return null;
    // if (lists.length == 1)
    // return lists[0];
    // ListNode finalList = new ListNode(0);

    // ListNode head = finalList;
    // for (int i = 1; i < lists.length; i++) {
    // ListNode headNode = new ListNode(0);
    // ListNode newNode = headNode;
    // ListNode list1 = finalList.next == null ? lists[i - 1] : finalList.next;
    // ListNode list2 = lists[i];

    // while (list1 != null && list2 != null) {
    // if (list1.val < list2.val) {
    // newNode.next = list1;
    // list1 = list1.next;
    // } else {
    // newNode.next = list2;
    // list2 = list2.next;
    // }
    // newNode = newNode.next;
    // }
    // if (list1 == null) {
    // newNode.next = list2;
    // }
    // if (list2 == null) {
    // newNode.next = list1;
    // }

    // finalList.next = headNode.next;

    // }

    // return head.next;

    // }
    // }

    // Using Min-Heap (Priority Queue) - O(N log K) time complexity
    // class Solution {
    // public ListNode mergeKLists(ListNode[] lists) {
    // PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val -
    // b.val);

    // for (int i = 0; i < lists.length; i++) {
    // if (lists[i] != null) {
    // minHeap.offer(lists[i]);
    // }
    // }

    // ListNode dummy = new ListNode(-1);
    // ListNode temp = dummy;
    // while (!minHeap.isEmpty()) {
    // ListNode currNode = minHeap.poll();
    // temp.next = currNode;
    // temp = temp.next;
    // if (currNode.next != null) {
    // minHeap.offer(currNode.next);
    // }
    // }
    // return dummy.next;

    // }
    // }

    // Using Divide and Conquer - O(N log K) time complexity
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0)
                return null;

            int interval = 1;
            int n = lists.length;

            while (interval < n) {
                for (int i = 0; i + interval < n; i += interval * 2) {
                    lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
                }
                interval *= 2;
            }

            return lists[0];
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

            tail.next = (l1 != null) ? l1 : l2;
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        // write your own test cases
    }

}