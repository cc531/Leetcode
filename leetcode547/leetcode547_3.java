class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        // traverse all cities
        for (int i = 0; i < n; i++) {
            // checking all cities connected with city i
            for (int j = i; j < n; j++) {
                // haven't visited city j yet
                if (visited[j] == false) {
                    count++;
                    visited[j] = true;
                    dfs(isConnected, visited, j);
                }
            }
        }

        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        // int n = isConnected.length;
        visited[city] = true;

        // visit all cites connected with 'city'
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1 && visited[i] == false) {
                dfs(isConnected, visited, i);
            }
        }

        return;
    }
}

// Runtime: 1 ms, faster than 68.27% of Java online submissions for Number of
// Provinces.
// Memory Usage: 40 MB, less than 38.07% of Java online submissions for Number
// of Provinces.
// time complexity: O(n * n) which there are n cities
// space complexity: O(n)