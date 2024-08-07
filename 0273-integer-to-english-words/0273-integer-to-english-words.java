public class Solution {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return convertToWord(num); 
    }
    
    private String convertToWord(int num) {
        String result = new String();
        
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num -10];
        else if (num < 100) result = belowHundred[num/10] + " " + convertToWord(num % 10);
        else if (num < 1000) result = convertToWord(num/100) + " Hundred " +  convertToWord(num % 100);
        else if (num < 1000000) result = convertToWord(num/1000) + " Thousand " +  convertToWord(num % 1000);
        else if (num < 1000000000) result = convertToWord(num/1000000) + " Million " +  convertToWord(num % 1000000);
        else result = convertToWord(num/1000000000) + " Billion " + convertToWord(num % 1000000000);
        
        return result.trim();
    }
}