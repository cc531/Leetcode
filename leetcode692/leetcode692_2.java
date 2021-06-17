class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, String> freq = new HashMap<>();

        for (String w : words) {
            freq.put(w, String.valueOf(Integer.valueOf(freq.getOrDefault(w, "0")) + 1));
        }

        PriorityQueue<String[]> pq = new PriorityQueue<>(
                (a, b) -> (Integer.valueOf(a[1]) == Integer.valueOf(b[1]) ? b[0].compareTo(a[0])
                        : Integer.valueOf(a[1]) - Integer.valueOf(b[1])));

        for (String key : freq.keySet()) {
            pq.add(new String[] { key, freq.get(key) });

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(0, pq.poll()[0]);
        }

        return ans;
    }
}

// Runtime: 7 ms, faster than 27.29% of Java online submissions for Top K
// Frequent Words.
// Memory Usage: 39 MB, less than 69.10% of Java online submissions for Top K
// Frequent Words.
// time complexity: O(n log n)
// space complexity: O(n)