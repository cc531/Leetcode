class Solution {
    // grid = { {"1","1","1","1","0"}, {"1","1","0","1","0"}, {"1","1","0","0","0"},
    // {"0","0","0","0","0"} }
    // {"0","0","0","0","0"}
    // {"1","1","0","0","0"}
    // y {"1","1","0","1","0"}
    // ^ {"1","1","1","1","0"}
    // | ->x

    // char[] {}
    // char[][] {char[]{}, char[]{}, char[]{}, char[]{}}
    // m(y) = 4, n(x) = 5
    // n : 每個y有幾個x
    // m : 有幾個y
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;

        // (x, y) = (j, i)
        // (0, 0) = 1; (1, 0) = 1; (2, 0) = 1; (3, 0) = 1; (4, 0) = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    // {"0","0","0","0","0"}
    // {"0","0","0","0","0"}
    // y {"0","0","0","0","0"}
    // ^ {"0","0","0","0","0"}
    // | ->x
    // q: {0,0}
    // pos = {0,0}. q: {1,0} {0,1}
    // pos = {1, 0} q: {0,1} {2,0} {1, 1}
    // pos = {0, 1} q: {2,0} {1, 1} {0,2}
    // pos = {2, 0} q: {1, 1} {0,2} {2,1}
    // pos = {1, 1} q: {0, 2} {2,1}
    // pos = {0, 2} q: {2, 1} {0, 3}
    // pos = {2, 1} q: {0, 3}
    // pos = {0, 3} q: {1, 3}
    // pos = {1, 3}
    private void bfs(char[][] grid, int y_start, int x_start) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { y_start, x_start });
        // set grid[y][x] to 0
        grid[y_start][x_start] = '0';

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int y = pos[0];
            int x = pos[1];

            // down
            if (y >= 1 && grid[y - 1][x] == '1') {
                q.add(new int[] { y - 1, x });
                grid[y - 1][x] = '0';
            }
            // up
            if (y < m - 1 && grid[y + 1][x] == '1') {
                q.add(new int[] { y + 1, x });
                grid[y + 1][x] = '0';
            }
            // left
            if (x >= 1 && grid[y][x - 1] == '1') {
                q.add(new int[] { y, x - 1 });
                grid[y][x - 1] = '0';
            }
            // right
            if (x < n - 1 && grid[y][x + 1] == '1') {
                q.add(new int[] { y, x + 1 });
                grid[y][x + 1] = '0';
            }
        }
    }
}

// Runtime: 2 ms, faster than 44.68% of Java online submissions for Number of
// Islands.
// Memory Usage: 41 MB, less than 98.16% of Java online submissions for Number
// of Islands.
// time complexity: O(m * n)
// space complexity: O(m * n)