class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        double count;
        // exp will alwyas be positive
        int exp;
        int remain = n;

        // n = 1234
        if (remain > 0) {
            count = x;
        }
        // n = -1234
        // 2^(-1) = 1 / 2
        else {
            count = 1 / x;
        }
        exp = 1;

        // find max of count
        // for example x = 2 n = 5
        // count = (2 * 2) * (2 * 2) = 2 ^ 4
        // exp = 4
        // Integer.MAX_VALUE = 2147483647
        // Integer.MIN_VALUE = -2147483648
        // n = -5
        // a = x^n => a^2 = (x^n) * (x^n) => x^(n * 2)
        // exp = 2 => -2 * 2 > -5
        // exp = 4 => -4 * 2 < -5
        // x = 2 n = 5
        // count = 2^4 exp = 4
        // x = 2 n = -5
        // count = 2^(-4) exp = 4
        // Math.abs(Integer.MIN_VALUE) = Integer.MIN_VALUE == Integer.MAX_VALUE + 1
        while ((remain > 0 && exp * 2 <= remain && exp < Integer.MAX_VALUE / 2)
                || (remain < 0 && -exp * 2 > remain && exp > Integer.MIN_VALUE / 2)) {
            count = count * count;
            exp = exp * 2;
        }

        // remain != 0. ans still needs to multiple x
        while (remain != 0) {
            ans *= count;
            // remain = 5
            // exp = 4
            if (remain > 0) {
                remain -= exp;
            }
            // remain = -5
            // exp = 4
            else {
                remain += exp;
            }

            // until exp < Math.abs(remain)
            while (exp > Math.abs(remain) && remain != 0) {
                // exp = 5
                // count = x^(exp)
                // pow(x, n) = x^(remain) * ans
                if (exp % 2 == 1) {
                    // remain > 0 pow(x,remain) = x*x...x
                    // 2^7 = 2^4 * 2^2 * 2^1
                    // 2^9 = 2^8 * 2^1
                    // 2^17 = 2^16 * 2^1
                    // 2^19 = 2^16 * 2^2 * 2^1
                    // 2^1025 = 2^1024 * 2^1
                    // 2^4097 = 2^4096 * 2^1
                    // 2^1
                    // count = 2 ^ 5 => 2^4
                    if (remain > 0) {
                        count /= x;
                    }
                    // count 1 /
                    else {
                        count *= x;
                    }
                    exp--;
                }
                count = Math.sqrt(count);
                exp /= 2;
            }
        }

        // if x is negatvie
        if (x < 0 && n % 2 == 1) {
            ans *= -1;
        }

        return ans;
    }
}

// Runtime: 1 ms, faster than 25.87% of Java online submissions for Pow(x, n).
// Memory Usage: 38.2 MB, less than 66.42% of Java online submissions for Pow(x,
// n).
// time complexity: O(log n)
// space complexity: O(1)