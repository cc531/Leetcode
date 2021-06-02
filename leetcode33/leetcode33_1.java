class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            // avoid overflow
            // left = INT_MAX / 2
            // right = INT_MAX / 2 + 100
            // left + right > INT_MAX => overflow
            // left + (100) /2 < INT_MAX
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            // the first half is sorted
            // 1 2 3 4 5 6 7 left = 0 right = 7 middle = 3
            // 3 4 5 6 7 1 2
            // 4 5 6 7 1 2 3
            if (nums[left] <= nums[middle]) {
                // 1 2 3 4 5 6 7 target = 3
                // 3 4 5 6 7 1 2 target = 3
                // 4 5 6 7 1 2 3 target = 5
                if (nums[left] <= target && target < nums[middle]) {
                    right = middle;
                }
                // 1 2 3 4 5 6 7 target = 6
                // 3 4 5 6 7 1 2 target = 7 || 1
                // 4 5 6 7 1 2 3 target = 1
                else {
                    left = middle + 1;
                }

            }
            // the second half is sorted
            // 5 6 7 1 2 3 4 middle = 3
            // 6 7 1 2 3 4 5 middle = 3
            else {
                // 5 6 7 1 2 3 4 target = 3
                // 6 7 1 2 3 4 5 target = 3
                if (nums[middle] < target && target <= nums[right - 1]) {
                    left = middle + 1;
                }
                // 5 6 7 1 2 3 4 target = 6
                // 6 7 1 2 3 4 5 target = 7
                else {
                    right = middle;
                }

            }
        }

        return -1;
    }
}

// Runtime: 1 ms, faster than 10.21% of Java online submissions for Search in
// Rotated Sorted Array.
// Memory Usage: 38.9 MB, less than 6.63% of Java online submissions for Search
// in Rotated Sorted Array.
// time complexity: O(log n)
// space complexity: O(1)
// ref:
// https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14436/Revised-Binary-Search