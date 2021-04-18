class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> orderMap = new HashMap<>();
        // orderMap[0] == 'a', orderMap[1] == 'b'
        // orderMap[0] = 4, orderMap[1] = 10
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {

            for (int j = 0; j < words[i].length(); j++) {
                // If we do not find a mismatch letter between words[i] and words[i + 1],
                // we need to examine the case when words are like ("apple", "app").
                if (j >= words[i + 1].length())
                    return false;

                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    if (orderMap.get(words[i].charAt(j)) > orderMap.get(words[i + 1].charAt(j)))
                        return false;
                    // if we find the first different letter and they are sorted,
                    // then there's no need to check remaining letters
                    else
                        break;
                }
            }
        }
        return true;
    }
}

// Runtime: 1 ms, faster than 42.66% of Java online submissions for Verifying an
// Alien Dictionary.
// Memory Usage: 38.7 MB, less than 31.45% of Java online submissions for
// Verifying an Alien Dictionary.
// time:O(m*n)
// space:O(1)