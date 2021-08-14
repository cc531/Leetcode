class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    int atMostK(int[] A, int K) {
        int left = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int right = 0; right < A.length; ++right) {
            if (count.getOrDefault(A[right], 0) == 0)
                K--;
            count.put(A[right], count.getOrDefault(A[right], 0) + 1);

            while (K < 0) {
                count.put(A[left], count.get(A[left]) - 1);
                if (count.get(A[left]) == 0)
                    K++;
                left++;
            }
            // length means num of subString
            res += right - left + 1;
        }
        return res;
    }
}