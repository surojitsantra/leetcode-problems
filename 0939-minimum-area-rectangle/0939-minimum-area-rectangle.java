class Solution {
    public int minAreaRect(int[][] points) {
        Set<String> pointSets = new HashSet<>();
        for(int[] point :points) pointSets.add(point[0] + "_" + point[1]);

        int minRectangle = Integer.MAX_VALUE;
        final int N = points.length;

        for(int i = 0; i < N; i++) {
            for(int j = i +1; j < N; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if(x1 == x2 || y1 == y2) continue;

                int x3 = x1;
                int y3 = y2;
                int x4 = x2;
                int y4 = y1;

                if(!pointSets.contains(x3 + "_" + y3)) continue;
                if(!pointSets.contains(x4 + "_" + y4)) continue;

                int length = Math.abs(x1 -x2);
                int width = Math.abs(y2 -y1);

                minRectangle = Math.min(minRectangle, length *width);

            }
        }

        return (minRectangle == Integer.MAX_VALUE)? 0 : minRectangle;
    }
}