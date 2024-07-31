class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        
        int[][] dp = new int[books.length][shelfWidth +1];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return minHeight(books, 0, shelfWidth, 0, shelfWidth, dp);
    }
    
    private int minHeight(int[][] books, int i, int currShelfRemWidth, int currShelfHeight, int shelfWidth, int[][] dp) {
        if(i >= books.length) {
            return currShelfHeight;
        }
        if(dp[i][currShelfRemWidth] != -1) {
            return dp[i][currShelfRemWidth];
        }
        
        int[] book = books[i];
        int sameShelf = Integer.MAX_VALUE;
        
        if(book[0] <= currShelfRemWidth) {
            sameShelf = minHeight(books, i +1, currShelfRemWidth -book[0], Math.max(currShelfHeight, book[1]), shelfWidth, dp);
        }
        int newShelf = currShelfHeight +minHeight(books, i +1, shelfWidth -book[0], book[1], shelfWidth, dp);
        
        return dp[i][currShelfRemWidth] = Math.min(sameShelf, newShelf);
        
    }
    
}