class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> obstaclesMap = new HashMap<>();
        
        for(int[] obstacle :obstacles) {
            obstaclesMap.putIfAbsent(obstacle[0], new HashSet<>());
            obstaclesMap.get(obstacle[0]).add(obstacle[1]);
        }
        
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int maxDis = 0;
        int currentDirection = 0; // 0: North, 1: East, 2: South, 3: West
        int x = 0, y = 0;
        
        for(int command :commands) {
            if(command == -1) {
                currentDirection = (currentDirection +1) %4;
            } else if(command == -2) {
                currentDirection = (currentDirection +3) %4;
            } else {
                int[] direction = directions[currentDirection];
                for(int step = 0; step < command; step++) {
                    int nextX = x + direction[0];
                    int nextY = y + direction[1];
                    
                    if(obstaclesMap.containsKey(nextX)
                      && obstaclesMap.get(nextX).contains(nextY)) {
                        break;
                    }
                    x = nextX;
                    y = nextY;
                    
                    maxDis = Math.max(maxDis, (x *x) + (y *y));
                }
            }
        }
        
        return maxDis;
    }
}