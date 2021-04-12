class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int p1 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums, p1, i);
                p1++;
            }
        }
        return;
    }

    public void swap(int[] nums1, int p1, int p2) {
        int tmp = nums1[p1];
        nums1[p1] = nums1[p2];
        nums1[p2] = tmp;
    }
}
// 0, 1, 0, 3, 12
// 1, 0 0 3
// 1, 3, 0, 0
// 1, 3, 12, 0, 0

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Move
// Zeroes.
// Memory Usage: 39.2 MB, less than 63.31% of Java online submissions for Move
// Zeroes.
// time:O(n)
// space:O(1)