class Trie {
    public Map<String, Trie> childs = new HashMap<>();
    public boolean isEnd = false;
}

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, (a, b) -> countFolder(a) -countFolder(b));
        
        List<String> result = new ArrayList<>();
        
        Trie root = new Trie();
        for(String path :folder) {
            String[] dirs = path.split("/");
            Trie node = root;
            boolean hasParent = false;
            for(String dir :dirs) {
                if(!node.childs.containsKey(dir)) {
                    node.childs.put(dir, new Trie());
                }
                node = node.childs.get(dir);
                if(node.isEnd) {
                    hasParent = true;
                    break;
                }
            }
            
            if(!hasParent) {
                result.add(path);
                node.isEnd = true;
            }
            
        }
        
        return result;
    }
    
    private int countFolder(String folder) {
        return folder.split("/").length;
    }
    
}