class Solution {
    public int maxProfit(int[] prices) {
        /*
        //a
            prices cant be -ve?
            max and min value of prices[i]?
        //l
            buy is min then sell can be maximise
            buy must be before sell
        //e
        //t
        //s
        */
            if(prices.length==0 || prices.length<2)return 0;
            int min=Integer.MAX_VALUE,max=0;
            for(int p: prices){
                min=Math.min(min,p);
                max=Math.max(max,p-min);
            }
            return max;
    }
}
