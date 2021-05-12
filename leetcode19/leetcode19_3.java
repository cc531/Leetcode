/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Advances first pointer so that the gap between first and second is n nodes
        // apart
        // n = 2
        // dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null
        // fast
        // slow ************ fast
        // move n + 1 steps
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }

        // Move first to the end, maintaining the gap
        // dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null
        // ***************** slow ********** fast
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth
// Node From End of List.
// Memory Usage: 37 MB, less than 36.31% of Java online submissions for Remove
// Nth Node From End of List.
// time complexity: O(n)
// space complexity: O(1)