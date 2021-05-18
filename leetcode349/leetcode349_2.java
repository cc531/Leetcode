class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // 因為不知道長度,不能用int[], 要用ArrayList<Integer>之後再轉回int[]
        ArrayList<Integer> arrL = new ArrayList<>();

        int p1 = 0, p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                arrL.add(nums1[p1]);

                // skip same number
                int num = nums1[p1];
                while (p1 < nums1.length && num == nums1[p1]) {
                    p1++;
                }
                while (p2 < nums2.length && num == nums2[p2]) {
                    p2++;
                }
            }
            // nums1[p1] < nums2[p2]
            else if (nums1[p1] < nums2[p2]) {
                p1++;
            }
            // nums1[p1] > nums2[p2]
            else {
                p2++;
            }
        }

        int[] arr = new int[arrL.size()];
        int i = 0;
        for (Integer num : arrL) {
            arr[i] = num;
            i++;
        }

        return arr;

    }
}

// Runtime: 2 ms, faster than 93.21% of Java online submissions for Intersection
// of Two Arrays.
// Memory Usage: 38.9 MB, less than 87.65% of Java online submissions for
// Intersection of Two Arrays.
// time complexity: O(n log n + m log m)
// space complexity: O(n + m)