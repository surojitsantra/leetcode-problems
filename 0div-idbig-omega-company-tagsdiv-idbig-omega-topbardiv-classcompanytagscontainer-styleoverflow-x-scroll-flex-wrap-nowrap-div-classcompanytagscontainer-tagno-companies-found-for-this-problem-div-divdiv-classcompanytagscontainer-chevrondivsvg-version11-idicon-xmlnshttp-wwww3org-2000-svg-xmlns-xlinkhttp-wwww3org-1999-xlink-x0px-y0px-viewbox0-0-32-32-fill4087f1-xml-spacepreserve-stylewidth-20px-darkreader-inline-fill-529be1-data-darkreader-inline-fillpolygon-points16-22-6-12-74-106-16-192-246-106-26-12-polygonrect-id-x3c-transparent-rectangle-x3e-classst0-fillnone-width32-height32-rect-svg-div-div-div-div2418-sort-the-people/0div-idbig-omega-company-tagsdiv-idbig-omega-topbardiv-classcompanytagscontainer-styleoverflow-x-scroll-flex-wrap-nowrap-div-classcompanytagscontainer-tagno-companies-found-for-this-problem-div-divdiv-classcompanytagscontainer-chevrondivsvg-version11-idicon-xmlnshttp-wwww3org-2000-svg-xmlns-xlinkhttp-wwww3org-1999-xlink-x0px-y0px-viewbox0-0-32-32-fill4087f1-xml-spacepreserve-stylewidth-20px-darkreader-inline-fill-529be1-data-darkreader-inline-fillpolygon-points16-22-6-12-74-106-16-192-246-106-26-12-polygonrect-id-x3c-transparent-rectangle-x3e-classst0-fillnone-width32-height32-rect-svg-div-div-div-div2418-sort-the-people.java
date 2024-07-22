class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
        int numberOfPeople = names.length;

        TreeMap<Integer, String> heightToNameMap = new TreeMap<>();

        for (int i = 0; i < numberOfPeople; i++) {
            heightToNameMap.put(heights[i], names[i]);
        }

        String[] sortedNames = new String[numberOfPeople];

        int currentIndex = numberOfPeople -1;
        for (int height : heightToNameMap.keySet()) {
            sortedNames[currentIndex] = heightToNameMap.get(height);
            currentIndex--;
        }

        return sortedNames;
    }
}