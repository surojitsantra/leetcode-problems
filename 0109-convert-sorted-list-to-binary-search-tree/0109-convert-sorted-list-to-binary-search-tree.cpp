/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
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
    TreeNode* sortedListToBST(ListNode* head) {
        if(!head) return nullptr;
        int len = getLen(head);
        
        return makeTree(head, len);
    }
    
private:
    int getLen(ListNode* node) {
        int len = 0;
        while(node) {
            len++;
            node = node->next;
        }
        return len;
    }
    TreeNode* makeTree(ListNode* node, int len) {
        if(len == 0) return nullptr;
        ListNode* currNode = node;
        
        for(int i = 1; i <= len /2; i++) {
            currNode = currNode->next;
        }
        
        TreeNode* root = new TreeNode(currNode->val);
        
        root->left = makeTree(node, len /2);
        root->right = makeTree(currNode->next, (len -1) /2);
        
        return root;
    }
};