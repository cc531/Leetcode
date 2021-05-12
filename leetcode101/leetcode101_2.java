/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null)
                continue;
            if (t1 == null || t2 == null)
                return false;
            if (t1.val != t2.val)
                return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }

        return true;
    }
}
// q: 1 1
// t1 = 1 t2 = 1 q:
// q: 2(L) 2(R) 2(R) 2(L)
// t1 = 2(L) t2 = 2(R) q : 2(R) 2(L)
// q: 2(R) 2(L) 3(L) 3(R) 4(L) 4(R)

// t1 = 2(R) t2 = 2(L) q : 3(L) 3(R) 4(L) 4(R)
// q: 3(L) 3(R) 4(L) 4(R) 4(R) 4(L) 3(R) 3(L)
// t1 = 3(L) t2 = 3(R) q :4(L) 4(R) 4(R) 4(L) 3(R) 3(L)
// q: 4(L) 4(R) 4(R) 4(L) 3(R) 3(L) null null null null
// t1 = 4(L) t2 = 4(R) q: 4(R) 4(L) 3(R) 3(L) null null null null
// q: 4(R) 4(L) 3(R) 3(L) null null null null null null null null
// t1 = 4(R) t2 = 4(L) q: 3(R) 3(L) null null null null null null null null
// q: 3(R) 3(L) null null null null null null null null null null null null
// t1 = 3(R) t2 = 3(L) q: null null null null null null null null null null null
// null
// q: null null null null null null null null null null null null null null null
// null
// t1= null t2 = null q: null null null null null null null null null null null
// null null null
// q: null null null null null null null null null null null null null null
// t1 = null t2 = null q: null null null null null null null null null null null
// null
// q: null null null null null null null null null null null null

// Runtime: 1 ms, faster than 23.13% of Java online submissions for Symmetric
// Tree.
// Memory Usage: 38.6 MB, less than 7.34% of Java online submissions for
// Symmetric Tree.
// time complexity: O(n)
// space complexity: There is additional space required for the search queue.
// In the worst case, we have to insert O(n) nodes in the queue.
// Therefore, space complexity is O(n).