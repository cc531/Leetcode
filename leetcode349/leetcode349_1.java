class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            if (!set1.contains(nums1[i])) {
                set1.add(nums1[i]);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (!set2.contains(nums2[i]) && set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }

        int[] ans = new int[set2.size()];
        int i = 0;
        for (Integer num : set2) {
            ans[i] = num;
            i++;
        }

        return ans;
    }
}

// Runtime: 2 ms, faster than 93.21% of Java online submissions for Intersection
// of Two Arrays.
// Memory Usage: 39.3 MB, less than 30.89% of Java online submissions for
// Intersection of Two Arrays.
// time complexity: O(m + n)
// space complexity: O(m + n)