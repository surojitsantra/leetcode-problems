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
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        vector<TreeNode*> duplicates;
        
        unordered_map<string, int> treeFreq;
        findSubtrees(root, treeFreq, duplicates);
        
        return duplicates;
    }
    
private:
    string findSubtrees(TreeNode* root, unordered_map<string, int>& treeFreq, vector<TreeNode*>& duplicates) {
        
        if(!root) return "";
        
        string leftTree = findSubtrees(root->left, treeFreq, duplicates);
        string rightTree = findSubtrees(root->right, treeFreq, duplicates);
        string subtree = to_string(root->val) +"#" +leftTree +"#" +rightTree;
        
        treeFreq[subtree]++;
        if(treeFreq[subtree] == 2) duplicates.push_back(root);
        
        return subtree;
    }
};