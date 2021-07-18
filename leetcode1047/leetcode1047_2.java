class Solution {
    public String removeDuplicates(String S) {
        StringBuilder ans = new StringBuilder();

        for (Character c : S.toCharArray()) {

            // first time ans will be empty, so include len == 0 condition to avoid error
            if (ans.length() == 0 || ans.charAt(ans.length() - 1) != c) {
                ans.append(c);
            }

            else {
                ans.deleteCharAt(ans.length() - 1);
            }
        }

        return ans.toString();
    }
}

// Runtime: 15 ms, faster than 62.37% of Java online submissions for Remove All
// Adjacent Duplicates In String.
// Memory Usage: 39.7 MB, less than 38.30% of Java online submissions for Remove
// All Adjacent Duplicates In String.
// time complexity: O(n)
// space complexity: O(n)