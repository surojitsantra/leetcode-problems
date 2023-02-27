/*
// Definition for a QuadTree node.
class Node {
public:
    bool val;
    bool isLeaf;
    Node* topLeft;
    Node* topRight;
    Node* bottomLeft;
    Node* bottomRight;
    
    Node() {
        val = false;
        isLeaf = false;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }
    
    Node(bool _val, bool _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }
    
    Node(bool _val, bool _isLeaf, Node* _topLeft, Node* _topRight, Node* _bottomLeft, Node* _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
public:
    Node* construct(vector<vector<int>>& grid) {
        const int N = grid.size();
        return constructQuadTree(grid, 0, N -1, 0, N -1);
    }
private:
    Node* constructQuadTree(vector<vector<int>>& grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        
        if (rowStart > rowEnd || colStart > colEnd) return nullptr;
        
        int val = grid[rowStart][colStart];
        bool isLeaf = true;
        
        for(int row = rowStart; row <= rowEnd; row++) {
            for(int col = colStart; col <= colEnd; col++) {
                if(grid[row][col] != val) {
                    isLeaf = false;
                    break;
                }
            }
            if(!isLeaf) break;
        }
        
        if(isLeaf) return new Node(val, true);
        
        int rowMid = (rowStart + rowEnd) / 2;
        int colMid = (colStart + colEnd) / 2;
        
        Node* topLeft = constructQuadTree(grid, rowStart, rowMid, colStart, colMid);
        Node* topRight = constructQuadTree(grid, rowStart, rowMid, colMid+1, colEnd);
        Node* bottomLeft = constructQuadTree(grid, rowMid+1, rowEnd, colStart, colMid);
        Node* bottomRight = constructQuadTree(grid, rowMid+1, rowEnd, colMid+1, colEnd);
        
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
};