class Solution {
    // return all valid parenthesis with n pairs
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        }
        // n = 3
        // () 2P
        // () (())
        // () ()()
        // (2P)
        // () ()
        // 2P = (()) or ()()
        // n = 1
        // () left = 0 right = n - 1 - left = 0
        // (left) right == ()
        // (left)right
        // n = 3
        // (2P)0P --> ()() or(())
        // (1P)1P
        // (0P)2P
        // n = 0 ans: ""
        // n = 1 ans: ()
        // n = 2 ans: (()), ()()
        else {
            for (int c = 0; c < n; ++c) {
                // all possible cases in left
                for (String left : generateParenthesis(c)) {
                    // all possible cases in right
                    for (String right : generateParenthesis(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }
}

// Runtime: 15 ms, faster than 5.67% of Java online submissions for Generate
// Parentheses.
// Memory Usage: 39.9 MB, less than 5.63% of Java online submissions for
// Generate Parentheses.
// time complexity: O(2^2n)
// space complexity: O(n)