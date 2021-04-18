class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of the first m elements of nums1.
        int[] nums1Copy = new int[m];
        // reference type cannot write => nums1Copy[i] = nums1[i] only
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }
        // [1, 2, 3] nums1copy
        // [2, 5, 6] nums2

        // [1, 2, 2, 3, 5, 6] nums1

        // [3, 13, 13]
        // [2, 2, 2]
        // [2, 2, 2, ]

        // 1. nums1copy is exhausted => nums2
        // 2. nums2 is exhausted => nums1copy
        // 3. nums1copy[p1] <= num2[p2] => nums1copy[p1]
        // 4. nums2[p2] < nums1copy[p1] => nums2[p2]

        // Read pointers for nums1Copy and nums2 respectively.
        int p1 = 0;
        int p2 = 0;

        // Compare elements from nums1Copy and nums2 and write the smallest to nums1.
        for (int i = 0; i < m + n; i++) {
            // We also need to ensure that p1 and p2 aren't over the boundaries
            // of their respective arrays.
            // condition 2 || condition 3
            if (p2 == n || (p1 < m && nums1Copy[p1] <= nums2[p2])) {
                nums1[i] = nums1Copy[p1];
                p1++;
            } else {
                nums1[i] = nums2[p2];
                p2++;
            }
        }
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge
// Sorted Array.
// Memory Usage: 39.2 MB, less than 23.29% of Java online submissions for Merge
// Sorted Array.
// time complexity:O(m+n)
// space complexity:O(m)