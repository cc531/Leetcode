class Solution {
    public int[] sortedSquares(int[] nums) {
        int p1 = 0, p2 = nums.length - 1;
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int sq;

            if (Math.abs(nums[p1]) > Math.abs(nums[p2])) {
                sq = nums[p1];
                p1++;
            } else {
                sq = nums[p2];
                p2--;
            }
            result[i] = sq * sq;

        }

        return result;

    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of
// a Sorted Array.
// Memory Usage: 40.8 MB, less than 40.01% of Java online submissions for
// Squares of a Sorted Array.
// Time Complexity: O(N), where NN is the length of A.
// Space Complexity: O(N) if you take output into account and O(1) otherwise.