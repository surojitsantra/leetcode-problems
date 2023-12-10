class Solution {
    public int[][] transpose(int[][] matrix) {
        int width = matrix[0].length;
        int len = matrix.length;
        int[][] result = new int[width][len];
        for (int i = 0; i < width; i++){
            for (int j = 0; j < len; j++){
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }
}