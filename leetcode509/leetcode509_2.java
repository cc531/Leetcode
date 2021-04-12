class Solution {
    public int fib(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }

        // n >= 2
        // f_n = F(n)
        // f_n1 = F(n-1) = F(1)
        // f_n2 = F(n-2) = F(0)
        int f_n = 0, f_n1 = 1, f_n2 = 0;

        for (int i = 2; i <= n; i++) {
            f_n = f_n1 + f_n2;
            f_n2 = f_n1;
            f_n1 = f_n;
        }

        return f_n;
    }
}
// F(n-2), F(n-1)
// 0, 1, 1, 2, 3, 5

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci
// Number.
// Memory Usage: 36 MB, less than 12.47% of Java online submissions for
// Fibonacci Number.
// time:O(n)
// space:O(1)