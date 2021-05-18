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
                    dfs(isConnected, visited, j);
                }
            }
        }

        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int j) {
        Stack<Integer> q = new Stack<>();
        // add j
        q.push(j);
        visited[j] = true;

        // visit all cities in this provinces
        while (!q.isEmpty()) {
            int city = q.pop();

            // visit all cites connected with 'city'
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[city][i] == 1 && visited[i] == false) {
                    q.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}

// Runtime: 1 ms, faster than 68.27% of Java online submissions for Number of
// Provinces.
// Memory Usage: 39.8 MB, less than 64.49% of Java online submissions for Number
// of Provinces.
// time complexity: O(n * n) which there are n cities
// space complexity: O(n)