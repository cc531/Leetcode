class Solution {
    public int firstUniqChar(String s) {

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - 'a';
            arr[value]++;

        }

        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - 'a';
            if (arr[value] == 1) {
                return i;
            }
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