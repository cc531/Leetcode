class Solution {
    public int maxSubArray(int[] nums) {
        int max_ans = nums[0];

        // greedy
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];

            }
            max_ans = Math.max(max_ans, nums[i]);
        }

        return max_ans;

    }
}