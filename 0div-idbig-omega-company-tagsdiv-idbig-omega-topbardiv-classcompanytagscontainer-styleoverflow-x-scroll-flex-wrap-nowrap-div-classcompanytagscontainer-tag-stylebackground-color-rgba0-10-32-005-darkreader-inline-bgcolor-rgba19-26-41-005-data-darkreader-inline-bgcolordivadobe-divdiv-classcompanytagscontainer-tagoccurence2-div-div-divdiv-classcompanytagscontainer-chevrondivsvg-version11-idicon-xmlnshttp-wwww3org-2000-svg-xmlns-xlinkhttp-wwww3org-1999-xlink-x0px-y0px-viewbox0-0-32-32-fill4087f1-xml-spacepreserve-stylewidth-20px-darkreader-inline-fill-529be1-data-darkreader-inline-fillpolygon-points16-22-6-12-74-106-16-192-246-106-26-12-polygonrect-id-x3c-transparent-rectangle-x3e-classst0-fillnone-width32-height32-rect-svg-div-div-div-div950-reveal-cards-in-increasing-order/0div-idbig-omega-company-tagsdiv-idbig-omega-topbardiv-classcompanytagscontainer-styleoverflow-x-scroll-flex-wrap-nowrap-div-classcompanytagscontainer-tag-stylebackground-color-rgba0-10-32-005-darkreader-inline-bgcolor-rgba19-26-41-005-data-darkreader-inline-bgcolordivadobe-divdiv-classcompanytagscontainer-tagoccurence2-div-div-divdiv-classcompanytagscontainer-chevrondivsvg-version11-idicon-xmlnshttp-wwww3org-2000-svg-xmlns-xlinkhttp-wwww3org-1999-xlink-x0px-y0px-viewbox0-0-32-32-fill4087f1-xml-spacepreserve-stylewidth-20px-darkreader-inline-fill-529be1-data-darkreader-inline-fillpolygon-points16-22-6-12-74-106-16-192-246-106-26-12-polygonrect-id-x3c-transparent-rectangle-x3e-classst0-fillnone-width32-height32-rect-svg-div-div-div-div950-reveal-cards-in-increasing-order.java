class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        final int N = deck.length;
        int[] res = new int[N];

        Arrays.sort(deck);
        
        boolean fill = true;
        
        int indexInDeck = 0;
        int indexInResult = 0;
        
        while(indexInDeck < N) {
            if(res[indexInResult] == 0) {
                if(fill) {
                    res[indexInResult] = deck[indexInDeck];
                    indexInDeck++;
                }
                fill = !fill;
            }
            
            indexInResult = (indexInResult +1) % N;
        }
        
        return res;
    }
}