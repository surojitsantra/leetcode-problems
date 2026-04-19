class Solution {
    public int minCost(int[][] grid) {
        final int M = grid.length;
        final int N = grid[0].length;

        int[][] dist = new int[M][N];
        for(int[] d: dist) Arrays.fill(d, Integer.MAX_VALUE);

        dist[0][0] = 0;

        Deque<int[]> queue = new LinkedList<>();
        queue.addFirst(new int[] {0, 0, 0});

        int[][] directions = new int[][] {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        while(!queue.isEmpty()) {
            int[] point = queue.removeFirst();
            int x = point[0];
            int y = point[1];
            int c = point[2];

            for(int i = 0; i < 4; i++) {
                int[] dir = directions[i];
                int move = i +1;

                int nx = x +dir[0];
                int ny = y +dir[1];
                int nc = c;

                if(move != grid[x][y]) {
                    nc += 1;
                }

                if(0 <= nx && nx < M && 0 <= ny && ny < N && nc < dist[nx][ny]) {
                    dist[nx][ny] = nc;
                    if(move == grid[x][y]) {
                        queue.addFirst(new int[] {nx, ny, nc});
                    } else {
                        queue.addLast(new int[] {nx, ny, nc});
                    }
                }

            }

        }

        return dist[M -1][N -1];

    }
}