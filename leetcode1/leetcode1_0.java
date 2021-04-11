class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }
        return new int[] {};

    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
// Memory Usage: 39.4 MB, less than 22.14% of Java online submissions for Two
// Sum.
// time complexity:O(n^2)
// space complexity:O(1)