class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of the first m elements of nums1.
        int[] nums1copy = new int[m];

        // reference type cannot write => nums1Copy[i] = nums1[i] only
        for (int i = 0; i < m; i++) {
            nums1copy[i] = nums1[i];
        }

        // Read pointers for nums1Copy and nums2 respectively
        int p1 = 0, p2 = 0;

        // Compare elements from nums1Copy and nums2 and write the smallest to nums1
        for (int i = 0; i < m + n; i++) {
            // We also need to ensure that p1 and p2 aren't over the boundaries
            // of their respective arrays.
            // condition 2 || condition 3
            if (p2 == n || p1 <= m - 1 && nums1copy[p1] <= nums2[p2]) {
                nums1[i] = nums1copy[p1];
                p1++;
            } else {
                nums1[i] = nums2[p2];
                p2++;
            }

        }
    }
}