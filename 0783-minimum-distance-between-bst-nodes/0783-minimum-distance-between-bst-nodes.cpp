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
    int minDiffInBST(TreeNode* root) {
        int ans = INT_MAX;
        int prevNo = INT_MAX;
        
        inOrder(root, prevNo, ans);
        
        return ans;
    }
    
private:
    void inOrder(TreeNode* node, int& prevNo, int& ans) {
        if(!node) return;
        inOrder(node->left, prevNo, ans);
        
        ans = min(ans, abs(prevNo -node->val));
        prevNo = node->val;
        
        inOrder(node->right, prevNo, ans);
    }
};