class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Integer, Queue<int[]>> disToPoint = new HashMap<>();

        // priority queue original: 1 2 3 4 5
        // Decreasing priority queeu
        // PriorityQueue<>(Collections.reverseOrder())
        // priority queue now: 5 4 3 2 1 k = 5
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] point : points) {
            int dis = point[0] * point[0] + point[1] * point[1];

            if (disToPoint.get(dis) == null) {
                disToPoint.put(dis, new LinkedList<int[]>());
            }
            disToPoint.get(dis).add(point);

            pq.add(dis);

            // at most k distance in pq
            // k = 2
            // pq: 18
            // pq: 26 18
            // pq: 26 20 18
            if (pq.size() > k) {
                pq.poll();
            }
            // pq: 20 18
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            int dis = pq.poll();
            ans[i] = disToPoint.get(dis).poll();
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