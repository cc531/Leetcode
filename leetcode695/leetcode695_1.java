class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max_area = 0;

        // (x, y) = (j, i)
        // (0, 0) = 1; (1, 0) = 1; (2, 0) = 1; (3, 0) = 1; (4, 0) = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    max_area = Math.max(max_area, area);
                }
            }
        }

        return max_area;
    }

    private int bfs(int[][] grid, int y, int x) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { y, x });
        // set grid[y][x] to 0
        grid[y][x] = 0;
        int area = 0;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            y = pos[0];
            x = pos[1];
            area++;

            // down
            if (y > 0 && grid[y - 1][x] == 1) {
                q.add(new int[] { y - 1, x });
                grid[y - 1][x] = 0;
            }
            // up
            if (y < m - 1 && grid[y + 1][x] == 1) {
                q.add(new int[] { y + 1, x });
                grid[y + 1][x] = 0;
            }
            // left
            if (x > 0 && grid[y][x - 1] == 1) {
                q.add(new int[] { y, x - 1 });
                grid[y][x - 1] = 0;
            }
            // right
            if (x < n - 1 && grid[y][x + 1] == 1) {
                q.add(new int[] { y, x + 1 });
                grid[y][x + 1] = 0;
            }
        }

        return area;
    }
}