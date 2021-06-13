class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        List<String> ans = new LinkedList<>();
        Map<String, Integer> m = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey())
                        : o1.getValue() - o2.getValue();
            }
        });

        for (String s : words) {
            m.put(s, m.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : m.entrySet()) {
            q.add(e);
            if (q.size() > k) {
                q.poll();
            }
        }

        while (q.size() != 0) {
            ans.add(q.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;

    }
}