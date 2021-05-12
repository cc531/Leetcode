class Solution {
    // [0,2,2]
    // [2,2,0]
    // y [2,2,2]
    // x
    // (y,x)
    // q: (0,0) count = 6
    // time 0->1 size = 1
    // cur: (0,0) q: (1,0) (0,1) count = 4
    // time 1->2 size = 2
    // cur: (1,0) q: (0,1) (1,1) count = 3
    // cur: (0,1) q: (1,1) (0,2) count = 2
    // time 2->3 size = 2
    // cur: (1,1) q: (0,2) (2,1) count = 1
    // cur: (0,2) q: (2,1) count = 1
    // time 3->4 size = 1
    // cur: (2,1) q: (2,2) count = 0
    // time 4->5 size = 1
    // cur: (2,2) q:empty count = 0
    // stop

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        // number of fresh
        int count = 0;

        // [0,1,1] -> i = 2
        // [1,1,0] -> i = 1
        // [2, 1, 1] -> i = 0
        // j = 0, j = 1, j = 2

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
                // dirs.length = 4
                // dirs = {1, 0, -1, 0}
                // x = 0. y = 0
                // j = 0
                // dirs[0 % 4] = 1 dirs[(0+1) % 4] = 0
                // nextY = y + 1. nextX = x + 0
                // up
                // j = 1
                // dirs[1 % 4] = 0. dirs[(1+1) % 4] = -1
                // nextY = y + 0. nextX = x - 1
                // left
                // j = 2
                // dirs[2 % 4] = -1 dirs[(2+1) % 4] = 0
                // nextY = y - 1. nextX = x + 0
                // down
                // j = 3
                // dirs[3 % 4] = 0. dirs[(3+1) % 4] = 1
                // nextY = y + 0. nextX = x + 1
                // right
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