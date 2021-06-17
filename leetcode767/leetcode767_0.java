class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();

            // if (cur.getValue() == 0)
            // {
            // continue;
            // }

            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == cur.getKey()) {
                if (pq.isEmpty()) {
                    return "";
                }
                Map.Entry<Character, Integer> tmp = pq.poll();
                sb.append(tmp.getKey());
                tmp.setValue(tmp.getValue() - 1);
                if (tmp.getValue() > 0) {
                    pq.add(tmp);
                }

            } else {
                sb.append(cur.getKey());
                cur.setValue(cur.getValue() - 1);
            }

            if (cur.getValue() > 0) {
                pq.add(cur);
            }

        }
        return sb.toString();

    }
}