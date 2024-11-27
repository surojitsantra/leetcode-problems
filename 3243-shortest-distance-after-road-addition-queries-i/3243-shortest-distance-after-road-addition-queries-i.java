class Solution {

    // Function to find the minimum distance from node 0 to node n-1
    public int findMinDistance(List<List<Integer>> adjList, int n) {
        int[] dp = new int[n];
        dp[n - 1] = 0; // Base case: distance to destination (n-1) is 0

        // Iterate from the second last node down to the first node
        for (int currentNode = n - 2; currentNode >= 0; currentNode--) {
            int minDistance = n;
            // Explore neighbors to find the minimum distance
            for (int neighbor : adjList.get(currentNode)) {
                minDistance = Math.min(minDistance, dp[neighbor] + 1);
            }
            dp[currentNode] = minDistance; // Store the calculated distance for the current node
        }
        return dp[0];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Initialize edges between consecutive nodes
        for (int i = 0; i < n - 1; i++) {
            adjList.get(i).add(i + 1);
        }

        // Process each query to add new edges
        for (int[] road : queries) {
            int u = road[0];
            int v = road[1];
            adjList.get(u).add(v); // Add the directed edge from u to v

            // Calculate the minimum distance after adding the new edge
            answer.add(findMinDistance(adjList, n));
        }

        // Convert List<Integer> to int[] before returning
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result; // Return the results for each query
    }
}
