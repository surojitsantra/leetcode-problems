class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<String>();
        
        for(String dirOrFile :path.split("/")) {
            if(dirOrFile.equals("..") && !deque.isEmpty()) {
                deque.removeLast();
            } else if(!dirOrFile.equals(".") && !dirOrFile.equals("") && !dirOrFile.equals("..")) {
                deque.addLast(dirOrFile);
            }
        }
        
        StringBuilder canonicalPath = new StringBuilder();
        
        for (String dirOrFile : deque) {
            canonicalPath.append("/").append(dirOrFile);
        }
        
        return ((canonicalPath.length() == 0)? "/" : canonicalPath.toString());
    }
}