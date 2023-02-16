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
    int maxDepth(TreeNode* root) {
        int ans = 0;
        preOrder(root, 1, ans);
        return ans;
    }
    
private:
    void preOrder(TreeNode* node, int level, int& ans) {
        if(!node) return;
        preOrder(node->left, level +1,  ans);
        preOrder(node->right, level +1,  ans);
        ans = max(ans, level);
    }
};