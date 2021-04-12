class Solution {
    public int fib(int n) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        // {K: V} == {n: F(n)}
        hashmap.put(0, 0);
        hashmap.put(1, 1);

        for (int i = 2; i <= n; i++) {
            int fn = hashmap.get(i - 1) + hashmap.get(i - 2);
            hashmap.put(i, fn);
        }

        return hashmap.get(n);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci
// Number.
// Memory Usage: 35.7 MB, less than 42.33% of Java online submissions for
// Fibonacci Number.
// time:O(n)
// space:O(n)