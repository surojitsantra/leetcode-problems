class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Queue<Integer> helperQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) {
            return false;
        }
        helperQueue.add(root);
        visited.add(root);        
        
        while(!helperQueue.isEmpty()) {            
            int node = helperQueue.poll();
            
            int left = leftChild[node];   
            if(left != -1) {
                if(visited.contains(left)) return false;
                helperQueue.add(left);
                visited.add(left);
            }
            
            int right = rightChild[node];
            if(right != -1) {
                if(visited.contains(right)) return false;
                helperQueue.add(right);
                visited.add(right);
            }
        }
        
        return (visited.size() == n);
    }
    
    private int findRoot(int n, int[] left, int[] right) {
        Set<Integer> childs = new HashSet<>();
        
        for (int node : left) childs.add(node);

        for (int node : right) childs.add(node);

        for (int i = 0; i < n; i++) {
            if (!childs.contains(i)) {
                return i;
            }
        }

        return -1;
    }
    
}