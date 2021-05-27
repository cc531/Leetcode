class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        // number of fresh
        int count = 0;

        // find out all rotten orange
        // y
        for (int i = 0; i < m; i++) {
            // x
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] { i, j });
                else if (grid[i][j] == 1)
                    count++;
            }
        }

        // all rotten
        if (count == 0)
            return 0;

        int time = 0;
        // (y+1, x+0), (y+0,x-1), (y-1,x+0), (y+0,x+1)
        int[] dirs = new int[] { 1, 0, -1, 0 };

        // bfs
        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            // after i min
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int y = cur[0], x = cur[1];

                // four directions
                for (int j = 0; j < dirs.length; j++) {
                    // 1 0 -1 0
                    int nextY = y + dirs[(j) % dirs.length];
                    // 0 -1 0 1
                    int nextX = x + dirs[(j + 1) % dirs.length];

                    if ((nextY >= 0 && nextY < m) && (nextX >= 0 && nextX < n) && grid[nextY][nextX] == 1) {
                        q.add(new int[] { nextY, nextX });
                        grid[nextY][nextX] = 2;
                        count--;
                    }
                }
            }
        }

        if (count > 0)
            return -1;
        else
            return time - 1;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Rotting
// Oranges.
// Memory Usage: 37.9 MB, less than 99.19% of Java online submissions for
// Rotting Oranges.
// time complexity: O(m*n)
// space complexity: O(m*n)