class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //a
        // piles max length, can be empty?
        // piles can be -ve?
        // if h is 0 or -ve?
        // piles sorted?
        // l:
        // piles array : [pile1, pile2, pile3]
        // h: no of hours we have to eat banna
        // k: speed : pile per hour
        // return min k
        if(piles.length==0)return -1;
        //search max pile size that will be upperbound spped
        int maxPile=-1;
        for(int p: piles){
            maxPile=Math.max(maxPile,p); //O(n)
        }
        int l=1,r=maxPile;
        int res=maxPile;
        while(l<=r){ //log(r) or log(maxPile)
            int k= l+(r-l)/2; 
            if(isValid(k, h, piles)){// O(n)
                res=k;
                r=k-1;
            }else{
                // is in valid k Hence choose higher k
                // as lower k means take more time which cant be valid
                l=k+1;
            }
        }
        return res;

        //t:
       // maxPile intailize is O(n)
       // while loop : runs log(maxPile) times
       // for each iteration of while loop is valid called
       // isValid runs O(n) times
       // Combining these gives O(n⋅log(maxPile))
       //s
       //O(1)
    }

    private boolean isValid(int k, int h, int[] piles){
        double totalTime=0;
        for(int p: piles){
            double hrs= Math.ceil((double)p/k);
            totalTime+=hrs;
        }

        return totalTime<=h; //O(n)
    }
}
