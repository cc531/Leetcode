class Solution {
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        // down
        dfs(grid, r - 1, c);
        // up
        dfs(grid, r + 1, c);
        // left
        dfs(grid, r, c - 1);
        // right
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Number of
// Islands.
// Memory Usage: 41 MB, less than 98.16% of Java online submissions for Number
// of Islands.
// time complexity: O(nr * nc)
// space complexity: O(nr * nc)