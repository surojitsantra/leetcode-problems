/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(!root) return ans;
        
        queue<TreeNode*> helperQueue;
        helperQueue.push(root);
        int level = 0;
        
        while(!helperQueue.empty()) {
            int sz = helperQueue.size();
            vector<int> levelElement;
            
            while(sz--) {
                levelElement.push_back(helperQueue.front()->val);
                if(helperQueue.front()->left) helperQueue.push(helperQueue.front()->left);
                if(helperQueue.front()->right) helperQueue.push(helperQueue.front()->right);
                helperQueue.pop();
            }
            if(level&1) reverse(levelElement.begin(), levelElement.end());
            ans.push_back(levelElement);
            level++;
        }
        return ans;
    }
};