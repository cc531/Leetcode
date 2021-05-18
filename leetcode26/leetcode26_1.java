class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0, ignore_count = 0, pos = 0;
        // pos : 放unique數字的位子

        while (p < nums.length) {
            int num = nums[p];
            // put non-duplicated (unique) "p" to the left
            swap(nums, p, pos);
            pos++;
            p++;

            while (p < nums.length && nums[p] == num) {
                p++;
                ignore_count++;
            }
        }

        return nums.length - ignore_count;

    }

    public void swap(int[] swap, int p1, int p2) {
        int tmp = swap[p1];
        swap[p1] = swap[p2];
        swap[p2] = tmp;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove
// Duplicates from Sorted Array.
// Memory Usage: 40.5 MB, less than 89.52% of Java online submissions for Remove
// Duplicates from Sorted Array.
// time complexity: O(n)
// space complexity: O(1)