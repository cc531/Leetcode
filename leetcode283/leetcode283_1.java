class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] nums_copy = new int[n];
        int p = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums_copy[p] = nums[i];
                p++;
            }
        }
        // reference type cannot write => nums[i]=nums_copy[i] only
        for (int i = 0; i < n; i++) {
            nums[i] = nums_copy[i];
        }

        return;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Move
// Zeroes.
// Memory Usage: 39 MB, less than 89.13% of Java online submissions for Move
// Zeroes.
// time:O(n)
// space:O(n) cause new array in line4