/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();

        // add root left
        left.add(root.left);
        // add root right
        right.add(root.right);

        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode left_node = left.poll();
            TreeNode right_node = right.poll();

            // only one of node is null
            if ((left_node == null && right_node != null) || left_node != null && right_node == null) {
                return false;
            } else if (left_node == null && right_node == null) {
                continue;
            } else if (left_node.val != right_node.val) {
                return false;
            }
            // equal
            else {
                // first pair
                left.add(left_node.left);
                right.add(right_node.right);

                // second pair
                left.add(left_node.right);
                right.add(right_node.left);
            }
        }

        return true;
    }
}

// Runtime: 1 ms, faster than 22.97% of Java online submissions for Symmetric
// Tree.
// Memory Usage: 38.7 MB, less than 5.56% of Java online submissions for
// Symmetric Tree.
// time complexity: O(n)
// space complexity: O(n/2)