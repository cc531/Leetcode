class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());

        int alltime = 0;
        int cycle = n + 1;

        while (!pq.isEmpty()) {
            int worktime = 0;
            List<Integer> tmp = new ArrayList<>();

            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    tmp.add(pq.poll());
                    worktime++;
                }
            }

            for (int count : tmp) {
                if (count - 1 > 0) {
                    pq.offer(count - 1);
                }
            }
            alltime += !pq.isEmpty() ? cycle : worktime;
        }
        return alltime;
    }
}