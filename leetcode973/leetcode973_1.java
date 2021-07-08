class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Integer, Queue<int[]>> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] point : points) {
            int sum = point[0] * point[0] + point[1] * point[1];

            if (map.get(sum) == null) {
                map.put(sum, new LinkedList<int[]>());
            }
            map.get(sum).add(point);

            pq.add(sum);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            ans[i] = map.get(pq.poll()).poll();
        }

        return ans;
    }
}

// Runtime: 51 ms, faster than 11.94% of Java online submissions for K Closest
// Points to Origin.
// Memory Usage: 47.6 MB, less than 57.53% of Java online submissions for K
// Closest Points to Origin.
// time complexity: O(n log k)
// space complexity: O(n)