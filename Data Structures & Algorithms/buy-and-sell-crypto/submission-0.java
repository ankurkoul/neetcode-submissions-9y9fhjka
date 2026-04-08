class Solution {
    public int maxProfit(int[] prices) {
//a 
    //price cant be -ve? 
    //atleast 2 must 
    //need to buy first and then sell both on differnet days
    // max profit if buy at min and sell at max but buy before sell
    // in case of decreasing : means -ve profit?

//e
    if(prices.length<2)return 0;
    int max=0;
    int n=prices.length;
    // 2pointer
    // for(int b=0;b<n;b++)
    //     for(int s=b+1;s<n;s++){ 
    //         int p= prices[s]-prices[b];
    //         max=Math.max(max,p);
    //     }

    // 2ptr
    int b=0, s=1;
    while(s<n){
        if(prices[b]<prices[s]){
            int p= prices[s]-prices[b];
             max=Math.max(max,p);
        }else{
            // not lowest buy hence update buy
            b=s;
        }
        s++;
    }
    return max;

//c
//t
//s
    }
}
