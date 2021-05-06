class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // 因為不知道長度,不能用int[], 要用ArrayList<Integer>之後再轉回int[]
        ArrayList<Integer> ans = new ArrayList<>();

        int p1 = 0, p2 = 0;
        int n1 = nums1.length, n2 = nums2.length;

        while (p1 < n1 && p2 < n2) {
            // nums1[p1] == nums2[p2]
            if (nums1[p1] == nums2[p2]) {
                ans.add(nums1[p1]);

                // skip same number
                // num1 = 1 1 1 2 3 4 5
                // num2 = 1 1 4 4 4 6 7
                int num = nums1[p1];
                while (p1 < n1 && nums1[p1] == num) {
                    p1++;
                }
                while (p2 < n2 && nums2[p2] == num) {
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

        int[] output = new int[ans.size()];

        int j = 0;
        // ans -> output
        for (Integer num : ans) {
            output[j] = num;
            j++;
        }

        // error: incompatible types: Object[] cannot be converted to int[]
        // output = ans.toArray();

        return output;
    }
}

// Runtime: 2 ms, faster than 93.21% of Java online submissions for Intersection
// of Two Arrays.
// Memory Usage: 38.9 MB, less than 87.65% of Java online submissions for
// Intersection of Two Arrays.
// time complexity: O(n log n + m log m)
// space complexity: O(n + m)