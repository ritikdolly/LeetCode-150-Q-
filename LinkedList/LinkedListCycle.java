public class LinkedListCycle {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Method to check if cycle exists
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // move slow by 1
            fast = fast.next.next;   // move fast by 2

            if (slow == fast) {      // cycle detected
                return true;
            }
        }
        return false; // no cycle
    }

    public static void main(String[] args) {
        // Create nodes
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Link them: 3 -> 2 -> 0 -> -4
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create a cycle: -4 -> 2
        node4.next = node2;

        // Test
        boolean result = hasCycle(node1);
        System.out.println("Cycle Present: " + result); // Expected: true
    }
}
