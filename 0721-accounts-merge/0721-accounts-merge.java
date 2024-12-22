class DisjointSet {
    private final int V;
    private int[] parent;
    private int[] size;
    
    public DisjointSet(int V) {
        this.V = V;
        
        parent = new int[V];
        size = new int[V];
        
        for(int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
    }
    
    public void union(int x, int y) {
        int parentX = getParent(x);
        int parentY = getParent(y);
        
        if(parentX == parentY) {
            return;
        }
        
        if(size[parentX] > size[parentY]) {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        } else {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }
        
    }
    
    public boolean isSameComponent(int x, int y) {
        int parentX = getParent(x);
        int parentY = getParent(y);
        return parentX == parentY;
    }
    
    public int getParent(int x) {
        if(x == parent[x]) return x;
        
        return parent[x] = getParent(parent[x]);
    }
    
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final int N = accounts.size();
        
        DisjointSet disjointSet = new DisjointSet(N);
        
        Map<String, Integer> emailMap = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            List<String> account = accounts.get(i);
            
            for(int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if(emailMap.containsKey(email)) {
                    disjointSet.union(i, emailMap.get(email));
                } else {
                    emailMap.put(email, i);
                }
            }
            
        }
        
        Map<Integer, Set<String>> userIdWithEmail = new HashMap<>();
        
        for(Map.Entry<String, Integer> entry :emailMap.entrySet()) {
            String email = entry.getKey();
            int id = disjointSet.getParent(entry.getValue());
            
            userIdWithEmail.putIfAbsent(id, new TreeSet<>());
            userIdWithEmail.get(id).add(email);
            
        }
        
        
        List<List<String>> ans = new ArrayList<>();
        
        for(Map.Entry<Integer, Set<String>> entry :userIdWithEmail.entrySet()) {
            int id = entry.getKey();
            List<String> emails = new LinkedList<>(entry.getValue());
            
            emails.addFirst(accounts.get(id).get(0));
            
            ans.add(emails);
            
        }
        
        return ans;
    }
}