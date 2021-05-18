class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        int[] arr = new int[nums.length];
        int p1 = 0, p2 = nums.length - 1, pos = nums.length - 1;

        while (pos >= 0) {
            if (nums[p1] > nums[p2]) {
                arr[pos] = nums[p1];
                p1++;
            } else {
                arr[pos] = nums[p2];
                p2--;
            }
            pos--;
        }

        return arr;

    }
}

// 16 1 0 9 100
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of
// a Sorted Array.
// Memory Usage: 40.8 MB, less than 40.01% of Java online submissions for
// Squares of a Sorted Array.
// time complexity: O(n)
// space complexity: O(N) if you take output into account and O(1) otherwise.