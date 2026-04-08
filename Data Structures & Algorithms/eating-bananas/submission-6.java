class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //ICORE
        if(piles==null)return 0;
        //piles[i] range 0 to 2 billion then int is good
        // piles max range
        // h max range
        // output -> is speed min in int ?
        
        //here we take two boundaty what can be min and max speed
        // l-> minSpeed and maxSpeed to complete eat banana
        int minSpeed=1,maxSpeed=0;
        for(int p: piles){
            maxSpeed=Math.max(maxSpeed, p);
        }
        int desiredSpeed=maxSpeed;
        //optmise disered speed using binary search 
        //find mid speed which allow to eat all piles within time h
        while(minSpeed<=maxSpeed){
            int mid=minSpeed+(maxSpeed-minSpeed)/2;
            if( isValidSpeed(mid, piles,h)){
                desiredSpeed=mid;
                maxSpeed=mid-1;
            }else{
                minSpeed=mid+1;
            }
        }
        return desiredSpeed;
    }

    private boolean isValidSpeed(int speed, int[] piles, int h){
        int hrs=0;
        for(int p: piles){
            hrs+=Math.ceil((double)p/speed);
        }
        return hrs<=h;
    }
}
