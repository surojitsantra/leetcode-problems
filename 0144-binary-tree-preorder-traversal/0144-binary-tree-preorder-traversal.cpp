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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> preorderElements;
        
        stack<TreeNode*> helperStack;
        TreeNode* curNode = root;
        
        while(curNode != nullptr || !helperStack.empty()) {
            if(curNode == nullptr) {
                curNode = helperStack.top();
                helperStack.pop();
            }
            preorderElements.push_back(curNode->val);
            if(curNode->right) helperStack.push(curNode->right);
            
            curNode = curNode->left;
        }
        
        return preorderElements;
    }
};