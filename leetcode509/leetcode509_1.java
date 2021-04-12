class Solution {
    public int fib(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}

// 0, 1, 1, 2, 3, 5

// Runtime: 8 ms, faster than 18.65% of Java online submissions for Fibonacci
// Number.
// Memory Usage: 36 MB, less than 19.32% of Java online submissions for
// Fibonacci Number.
// time:O(2^n)
// space:O(n)