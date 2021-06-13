class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            // avoid overflow
            // left = INT_MAX / 2
            // right = INT_MAX / 2 + 100
            // left + right > INT_MAX => overflow
            // left + (100) /2 < INT_MAX
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // the first half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // the second half is sorted
            else {
                if (target <= nums[right - 1] && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

        }
        return -1;

    }
}