class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> alpha_index = new HashMap<Character, Integer>();

        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // first time
            if (!alpha_index.containsKey(c))
                alpha_index.put(c, i);
            // duplicate
            else
                alpha_index.put(c, -1);
        }

        // find the index
        // a...z
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (alpha_index.containsKey(c) && alpha_index.get(c) != -1) {
                ans = Math.min(ans, alpha_index.get(c));
                // map.get(key)
            }
        }

        // ans found
        if (ans != Integer.MAX_VALUE)
            return ans;

        return -1;
    }
}

// Runtime: 17 ms, faster than 59.28% of Java online submissions for First
// Unique Character in a String.
// Memory Usage: 39.6 MB, less than 36.74% of Java online submissions for First
// Unique Character in a String
// time :O(n)
// space :O(1)