/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {

    Random random = new Random();

    public void findSecretWord(String[] words, Master master) {
        List<String> wordsList = new ArrayList<>();
        for(String word :words) wordsList.add(word);

        int match = 0;
        while(match < 6) {
            List<String> filterredWords = new ArrayList<>();
            String guess = wordsList.get(random.nextInt(wordsList.size()));
            match = master.guess(guess);
            for(String word :wordsList) {
                if(match == getMatches(guess, word)) {
                    filterredWords.add(word);
                }
            }
            wordsList = filterredWords;

        }

    }


    private int getMatches(String maxMatchString, String word) {
        int charMatch = 0;

        for(int i = 0; i < 6; i++) {
            if(maxMatchString.charAt(i) == word.charAt(i)) {
                charMatch++;
            }
        }

        return charMatch;

    }
}