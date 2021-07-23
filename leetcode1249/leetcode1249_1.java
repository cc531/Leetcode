class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int left = 0;
        int deleteCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
                st.push(c);
            } else if (c == ')') {
                if (left > 0) {
                    st.push(c);
                    left--;
                }
                // if right num > left num
                // else, ignore this one, dont push into the stack

            } else {
                st.push(c);
            }
        }

        while (!st.isEmpty()) {

            // if left num > right num
            if (st.peek() == '(' && left > 0) {
                left--;
                st.pop();
                continue;
            }

            ans.insert(0, st.pop());
        }

        return ans.toString();
    }
}

// Runtime: 247 ms, faster than 8.05% of Java online submissions for Minimum
// Remove to Make Valid Parentheses.
// Memory Usage: 41.8 MB, less than 20.38% of Java online submissions for
// Minimum Remove to Make Valid Parentheses.
// time complexity: O(n)
// space complexity: O(n)