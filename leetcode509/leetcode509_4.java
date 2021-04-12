class Solution {
    public int fib(int n) {
        if (n <= 1)
            return n;

        int[] arr = new int[n + 1];

        // {K: V} == {n: F(n)}
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            int fn = arr[i - 1] + arr[i - 2];
            arr[i] = fn;
        }

        return arr[n];
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci
// Number.
// Memory Usage: 35.7 MB, less than 59.33% of Java online submissions for
// Fibonacci Number.
// time:O(n)
// space:O(n) cause of line6