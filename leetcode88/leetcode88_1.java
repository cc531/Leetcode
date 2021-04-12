class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }
}

// Runtime: 1 ms, faster than 12.94% of Java online submissions for Merge Sorted
// Array.
// Memory Usage: 39.1 MB, less than 48.24% of Java online submissions for Merge
// Sorted Array.
// time complexity:O((n+m)log(n+m)).
// space complexity:O(1)