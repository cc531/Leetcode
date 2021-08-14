public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];

        // intitalized 'start' to 'every positions' as Max_Value
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        // initialized start distance[0][4] = 0
        distance[start[0]][start[1]] = 0;
        // every 'start' to 'maze' need 'distance' steps
        dijkstra(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dijkstra(int[][] maze, int[] start, int[][] distance) {
        // 4 directions
        // dirs[row][col]
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        // a[2] - b[2] sort by distance
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        // elements in pq = {row, col, distance}
        queue.offer(new int[] { start[0], start[1], 0 });

        while (!queue.isEmpty()) {
            int[] s = queue.poll();

            // distance[] compares with s[2]
            // distance[] is better, ignore s[2]
            if (distance[s[0]][s[1]] < s[2])
                continue;

            // s[2] is better
            for (int[] dir : dirs) {

                // [row, col], s[0] = row, s[1] = col
                int row = s[0] + dir[0];
                int col = s[1] + dir[1];
                // from start to 'current stop' = count
                int count = 0;

                // while row and col do not hit the wall
                // while this position is not wall -> maze[row][col] == 0
                while (row >= 0 && col >= 0 && row < maze.length && col < maze[0].length && maze[row][col] == 0) {
                    row += dir[0];
                    col += dir[1];
                    count++;
                }

                // position + count < position before hit the wall
                if (distance[s[0]][s[1]] + count < distance[row - dir[0]][col - dir[1]]) {
                    distance[row - dir[0]][col - dir[1]] = distance[s[0]][s[1]] + count;
                    // elements in pq = {row, col, distance}
                    queue.offer(new int[] { row - dir[0], col - dir[1], distance[row - dir[0]][col - dir[1]] });
                }
            }
        }
    }
}

// Time complexity : O(mn*log(mn))
// queue.poll() -> time log(mn)
// Space complexity : O(mn)O(mn) -> distance[][]