class Solution {
    public int totalMoney(int n) {
        int floorWeek = n /7;
        int amount = (floorWeek *28) +(7 * ((floorWeek *(floorWeek -1)) /2));
        
        int remDays = n %7;
        
        int monday = 1 +floorWeek;
        for(int day = 0; day < remDays; day++) {
            amount += monday +day;
        }
        
        return amount;
    }
}