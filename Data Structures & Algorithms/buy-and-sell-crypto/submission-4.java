class Solution {
    public int maxProfit(int[] prices) {
        //a
        /*
        prices are within range of 10^6 hence can be int
        prices[i] are within range of 10^6 hence can be int
        u must buy before sell
        prices[i] cant be -ve
        max profit=major_sell_day - min_buy_day
        */
        //b
        if(prices==null|| prices.length==0)return 0;
        int min=prices[0],max=0;
        for(int p: prices){
            min=Math.min(min,p);
            max=Math.max(max, p-min);
        }
        return max;
    }
}
