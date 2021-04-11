class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];

        // left boundary
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;

            // right boundary
            for (int j = i; j < nums.length; j++) {
                tmp += nums[j];

                sum = Math.max(tmp, sum);
            }
        }
        return sum;
    }
}

// Runtime: 116 ms, faster than 6.80% of Java online submissions for Maximum
// Subarray.
// Memory Usage: 39 MB, less than 41.18% of Java online submissions for Maximum
// Subarray.
// time complexity:O(n^2)
// space complexity:O(1)