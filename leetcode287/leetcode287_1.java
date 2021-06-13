class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;

    }
}