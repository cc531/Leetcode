class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int com = target - nums[i];

            if (map.containsKey(com))
                return new int[] { map.get(com), i };
            else
                map.put(nums[i], i);
        }

        return new int[] {};
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
// Memory Usage: 38.9 MB, less than 88.96% of Java online submissions for Two
// Sum.
// time complexity : O(n)
// space complexity : O(n)