class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);

            // int tmp;
            // if (count.containskey(c))
            // tmp = count.get(c);
            // else
            // tmp = 0;
            // put(c, tmp + 1);
        }

        // find the index
        // leetcode
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}

// time:O(n)
// space:O(1)