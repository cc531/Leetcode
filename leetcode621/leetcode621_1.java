class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Pair<Character, Integer>(entry.getKey(), entry.getValue()));
        }

        int alltime = 0;
        int cycle = n + 1;

        while (!pq.isEmpty()) {
            int worktime = 0;
            List<Pair<Character, Integer>> tmp = new ArrayList<>();

            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    tmp.add(pq.poll());
                    worktime++;
                }
            }

            for (Pair<Character, Integer> cur : tmp) {
                if (cur.getValue() - 1 > 0) {
                    pq.offer(new Pair<Character, Integer>(cur.getKey(), cur.getValue() - 1));
                }
            }
            alltime += !pq.isEmpty() ? cycle : worktime;
        }
        return alltime;
    }
}