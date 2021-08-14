class Solution {
    public int numTeams(int[] rating) {

        int res = 0;
        for (int i = 1; i < rating.length - 1; ++i) {
            int less[] = new int[2], greater[] = new int[2];

            for (int j = 0; j < rating.length; ++j) {
                if (rating[i] < rating[j]) {
                    if (j > i)
                        greater[1]++;
                    else
                        greater[0]++;
                }

                if (rating[i] > rating[j]) {
                    // less{j < i, j > i}

                    if (j > i)
                        less[1]++;
                    else
                        less[0]++;
                }

            }
            res += less[0] * greater[1] + greater[0] * less[1];
        }
        return res;
    }
}

// time O(n^2)
// space O(1)