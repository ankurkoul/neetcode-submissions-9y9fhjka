class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //a
        // piles length ?
        // can negative piles ?
        // what is min or max value piles[i] can have?
        // what is min or max value of h?
        // is pile sorted?

        //l can be min speed
        // l=1
        // r can be max speed, r=maxPile value
        // use binary search to get mid 
        int l=0, r=0;
        for(int p: piles){
            r=Math.max(r,p);
        }
        int res=r;
        while(l<=r){
            int k=l+(r-l)/2;
            if(isValid(k,piles,h)){
                res=k;
                r=k-1;
            }else{
                l=k+1;
            }
        }
        return res;
    }

    boolean isValid(int k, int[]piles, int h){
        double sum=0;
        for(int p: piles){
            sum+= Math.ceil((double)p/k);
        }
        return sum<=h;
    }
}
