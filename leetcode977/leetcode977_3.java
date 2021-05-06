class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;

            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }

            result[i] = square * square;
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