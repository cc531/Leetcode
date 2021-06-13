class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        long cur = 1;
        // N = 11
        // i = 11 current_product = 2 == 2^1
        // i % 2 = 1 => ans *= 2 => ans = 2
        // current_product = current_product * current_product = 4 == 2^2
        // i / 2 = 5
        // i % 2 = 1 => ans *= 2^2 => ans = 8
        // current_product = current_product * current_product = 16 == 2^4
        // i / 2 = 2
        // i % 2 = 0
        // current_product = current_product * current_product = 256 == 2^8
        // i / 2 = 1
        // i % 2 = 1 => ans *= 2^8 => ans = 2048
        // ans = 1 * 2 * 4 * 256
        // i / 2 = 0
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
            cur = cur * cur;
        }
        return ans;
    }
};

// Runtime: 1 ms, faster than 26.74% of Java online submissions for Pow(x, n).
// Memory Usage: 38.9 MB, less than 7.95% of Java online submissions for Pow(x,
// n).
// time complexity: O(log n)
// space complexity: O(1)