/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // dummy -> 1 -> 2 -> 3 -> 4 -> 5
    //
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        int length = 0;

        // traverse linkedlist
        // dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null
        // cur ------> cur
        while (cur != null) {
            length++;
            cur = cur.next;

        }
        int target = length - n;

        // dummy -> 1 -> 2 -> 3 -> 4 -> 5
        // cur
        cur = dummy;

        while (target > 0) {
            target--;
            cur = cur.next;
        }

        // (cur.next = null) is acceptable but (null.next) is invalid
        cur.next = cur.next.next;

        return dummy.next;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth
// Node From End of List.
// Memory Usage: 37.2 MB, less than 18.74% of Java online submissions for Remove
// Nth Node From End of List.
// time complexity: O(n)
// space complexity: O(1)