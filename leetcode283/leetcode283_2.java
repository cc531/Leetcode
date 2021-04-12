class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int p1 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[p1] = nums[i];
                p1++;
            }
        }

        for (int i = p1; i < n; i++) {
            nums[i] = 0;
        }

        return;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Move
// Zeroes.
// Memory Usage: 39.4 MB, less than 23.52% of Java online submissions for Move
// Zeroes.
// time:O(n)
// space:O(1)