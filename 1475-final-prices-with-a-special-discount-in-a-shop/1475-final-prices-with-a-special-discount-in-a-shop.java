class Solution {
    public int[] finalPrices(int[] prices) {
        final int N = prices.length;
        int[] discountedPrice = new int[N];
        
        Stack<Integer> discounts = new Stack<>();
        
        for(int i = N -1; i >= 0; i--) {
            int price = prices[i];
            
            while(!discounts.isEmpty() && discounts.peek() > price) {
                discounts.pop();
            }
            
            int discount = 0;
            if(!discounts.isEmpty()) {
                discount = discounts.peek();
            }
            
            discountedPrice[i] = price -discount;
            discounts.push(price);
            
        }
        
        return discountedPrice;
    }
}