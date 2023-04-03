class Solution {
    public int numRescueBoats(int[] people, int limit) {
        final int N = people.length;
        Arrays.sort(people);
        
        int boatsReq = 0;
        
        int i = 0, j = N -1;
        while(i <= j) {
            if(people[i] +people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
            boatsReq++;
        }
        
        return boatsReq;
    }
}