class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max_ans = nums[0];

        for (int i = 1; i < n; i++) {

            // greedy
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];

            max_ans = Math.max(max_ans, nums[i]);
        }

        return max_ans;
    }
}
// [1] = 1
// [1, 2] = max([1] + 2, [2])
// [1, 2, 3] = max([1, 2] + 3, [3])

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum
// Subarray.
// Memory Usage: 38.7 MB, less than 72.29% of Java online submissions for
// time complexity:O(n)
// space complexity:O(1)