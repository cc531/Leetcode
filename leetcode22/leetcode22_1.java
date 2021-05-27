class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder cur = new StringBuilder();

        backtracking(n, ans, 0, 0, cur);

        return ans;
    }

    // n = 2
    // b: left right cur == ""
    // b: 0 0 ""
    // b: 1 0 "("
    // b: 2 0 "(("
    // b: 3 0 "(((" wrong left > n
    // b: 2 1 "(()"
    // b: 3 1 "(()(" wrong left > n
    // b: 2 2 "(())" okay
    // b: 1 1 "()"
    // b: 2 1 "()("
    // b: 3 1 "()((" wrong left > n
    // b: 2 2 "()()" okay
    // b: 0 1 ")" wrong right >

    private void backtracking(int n, List<String> ans, int left, int right, StringBuilder cur) {
        // left > n || right > n
        // invalid
        if (left > n || right > n) {
            return;
        }
        // invalid
        else if (right > left)
            return;
        // cur is a valid answer
        else if (left == n && right == n) {
            ans.add(cur.toString());
            return;
        }

        // length is not 2 * n
        // try add (
        cur.append('(');
        backtracking(n, ans, left + 1, right, cur);
        // remove (
        cur.deleteCharAt(cur.length() - 1);

        // try add )
        cur.append(')');
        backtracking(n, ans, left, right + 1, cur);
        // remove )
        cur.deleteCharAt(cur.length() - 1);
    }
}

// Runtime: 1 ms, faster than 70.80% of Java online submissions for Generate
// Parentheses.
// Memory Usage: 40.4 MB, less than 5.63% of Java online submissions for
// Generate Parentheses.
// time complexity: O(2^2n)
// space complexity: O(n)
// ()
// )(
// (()))(

// n = 1
// **
// (
// (( wrong # ( > # )
// () correct
// )
// )( wrong ) before (
// )) wrong #) > #(