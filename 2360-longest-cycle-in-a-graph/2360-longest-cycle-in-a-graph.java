class Solution {
  public int longestCycle(int[] edges) {
    int ans = -1; // Initialize the answer to -1
    int time = 1; // Initialize the current time step to 1
    int[] timeVisited = new int[edges.length]; // Initialize an array to store the time at which each node was first visited

    // Iterate through each node in the graph
    for (int i = 0; i < edges.length; ++i) {
      if (timeVisited[i] > 0) // If the node has already been visited, skip it
        continue;
      final int startTime = time; // Record the start time of the current traversal
      int u = i; // Initialize the current node to the ith node
      // Traverse the graph until the end of the path is reached or a visited node is encountered
      while (u != -1 && timeVisited[u] == 0) {
        timeVisited[u] = time++; // Record the current time step and increment time
        u = edges[u]; // Move to the next node in the path
      }
      // If a cycle is found that includes the current node, update the answer
      if (u != -1 && timeVisited[u] >= startTime)
        ans = Math.max(ans, time - timeVisited[u]);
    }

    return ans; // Return the length of the longest cycle found
  }
}