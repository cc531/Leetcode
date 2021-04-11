class Solution {
    public int maxSubArray(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int sum = nums[0];

        // left bound
        for (int i = 0; i < nums.length; i++) {
            // right bound
            for (int j = i; j < nums.length; j++) {
                int tmp = 0;

                // aggregation
                for (int k = i; k <= j; k++) {
                    tmp += nums[k];
                }

                sum = Math.max(tmp, sum);
            }
        }

        return sum;
    }
}