class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> alpha_count = new HashMap<>();

        // count s
        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);
            alpha_count.put(alpha, alpha_count.getOrDefault(alpha, 0) + 1);
        }

        // used on t
        for (int i = 0; i < t.length(); i++) {
            char alpha = t.charAt(i);

            if (alpha_count.containsKey(alpha))
                alpha_count.put(alpha, alpha_count.get(alpha) - 1);
            else
                return false;

            if (alpha_count.get(alpha) < 0)
                return false;
        }

        return true;
    }
}

// Runtime: 11 ms, faster than 21.43% of Java online submissions for Valid
// Anagram.
// Memory Usage: 39.5 MB, less than 32.12% of Java online submissions for Valid
// Anagram.
// time:O(n)
// space:O(1)-->HashMap max key = 26