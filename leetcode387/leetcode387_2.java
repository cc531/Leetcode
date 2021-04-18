class Solution {
    public int firstUniqChar(String s) {
        // HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int[] count = new int[26];

        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // count.put(c, count.getOrDefault(c, 0) + 1);
            int index = (int) (c - 'a');
            count[index]++;

        }

        // find the index
        for (int i = 0; i < n; i++) {
            // if (count.get(s.charAt(i)) == 1)
            // return i;
            char c = s.charAt(i);
            int index = (int) (c - 'a');
            if (count[index] == 1)
                return i;

        }
        return -1;
    }
}

// Runtime: 7 ms, faster than 84.26% of Java online submissions for First Unique
// Character in a String.
// Memory Usage: 39.2 MB, less than 79.41% of Java online submissions for First
// Unique Character in a String.
// time:O(n)
// space:O(1)