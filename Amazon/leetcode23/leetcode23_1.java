/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        PriorityQueue<ListNode> nextNode = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);

        for (ListNode node : lists) {
            if (node != null) {
                nextNode.add(node);
            }
        }

        while (!nextNode.isEmpty()) {
            ListNode node = nextNode.poll();
            point.next = node;
            point = point.next;
            node = node.next;

            if (node != null) {
                nextNode.add(node);
            }
        }

        return head.next;
    }
}