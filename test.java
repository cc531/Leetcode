class Solution {
    public int findCircleNum(int[][] isConnected) 
    {
        int m = isConnected.length;
        boolean[] visited = new boolean[m];
        int count = 0;

        for (int i = 0; i < m; i++) 
        {
            if (visited[i] == false)
                ;
            {
                count++;
                bfs(isConnected, visited, i);
            }
        }
        return count;
    }

    public void bfs(int[][] isConnected, boolean[] visited, int j) 
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(j);
        visited[j] = true;

        while (!q.isEmpty()) 
        {
            int city = q.poll();
            for (int i = 0; i < isConnected.length; i++) 
            {
                if (isConnected[city][i] == 1 && visited[i] == false) 
                {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}