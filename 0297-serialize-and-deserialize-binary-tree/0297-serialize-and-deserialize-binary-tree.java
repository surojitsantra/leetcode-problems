/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-- > 0) {
                TreeNode node = q.poll();
                if(!sb.isEmpty()) {
                    sb.append(",");
                }
                if(node == null) {
                    sb.append("#");
                } else {
                    sb.append(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        
        String[] levelOrder = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(levelOrder[0]));
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        final int N = levelOrder.length;
        int i = 1;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            
            if(i < N && !levelOrder[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(levelOrder[i])); 
                q.add(node.left);
            }
            i++;
            if(!levelOrder[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(levelOrder[i])); 
                q.add(node.right);
            }
            i++;
            
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));