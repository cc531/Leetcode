/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

    public boolean isPalindrome(ListNode head) {

        if (head == null)
            return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        while (p2 != null) {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // fast slow pointers
    // odd
    // 1 -> 2 -> 2 -> 1 -> null
    // s/f
    // ****Slow**Fast
    // even
    // 1 -> 2 -> 3 -> 2 -> 1 -> null
    // s/f
    // ****Slow**Fast
    // *********Slow******Fast
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

// Runtime: 6 ms, faster than 54.23% of Java online submissions for Palindrome
// Linked List.
// Memory Usage: 48.8 MB, less than 72.01% of Java online submissions for
// Palindrome Linked List.
// time complexity: O(n)
// space complexity: O(1)