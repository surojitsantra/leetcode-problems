class Solution {
    public int minCost(int[][] grid) {
        final int M = grid.length, N = grid[0].length;

        int[][] dist = new int[M][N];
        for(int[] d: dist) Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] -b[2]);
        minHeap.add(new int[] {0, 0, 0});
        dist[0][0] = 0;

        int[][] directions = new int[][] {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        while(!minHeap.isEmpty()) {
            int[] point = minHeap.poll();
            int r = point[0];
            int c = point[1];
            int cost = point[2];

            for(int i = 0; i < 4; i++) {
                int[] dir = directions[i];

                int move = i +1;

                int nr = r +dir[0];
                int nc = c +dir[1];

                int newCost = cost;
                if(move != grid[r][c]) {
                    newCost += 1;
                }

                if(0 <= nr && nr < M && 0 <= nc && nc < N && newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    minHeap.add(new int[] {nr, nc, newCost});
                }

            }

        }

        return dist[M -1][N -1];


    }
}