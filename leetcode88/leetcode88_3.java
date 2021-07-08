class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int p1 = m - 1, p2 = n - 1;

        // And move p backwards through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (int i = m + n - 1; i >= 0; i--) {
            if (p2 < 0)
                break;

            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
        }

    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge
// Sorted Array.
// Memory Usage: 39.2 MB, less than 23.29% of Java online submissions for Merge
// Sorted Array.
// time complexity:O(m+n)
// space complexity:O(1)
