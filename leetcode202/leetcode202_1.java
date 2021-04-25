class Solution {

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        // return n == 1;
        if (n == 1)
            return true;
        else
            return false;
    }
}

// Runtime: 1 ms, faster than 81.04% of Java online submissions for Happy
// Number.
// Memory Usage: 35.5 MB, less than 96.11% of Java online submissions for Happy
// Number.
// time:log(n)
// sapce:log(n)