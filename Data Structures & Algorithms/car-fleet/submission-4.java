class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(target<=0)return 0; 
        if(position==null || speed==null)return 0;
        int n=position.length;
        if(speed.length!=n)return -1;
        Map<Double,Integer> remainingDistSpeedMap=new TreeMap<>();
        for(int i=0;i<n;i++){
            remainingDistSpeedMap.put((double)target-position[i], speed[i]);
        }
        //montainc increasing stack based on hrs to reach
        Deque<Double> incStack=new ArrayDeque<>();
        for(Map.Entry<Double,Integer> e: remainingDistSpeedMap.entrySet()){
            Double remainingDist=e.getKey();
            int currentSpeed=e.getValue();
            Double remainingTime= remainingDist /currentSpeed;
            if(incStack.isEmpty() || incStack.peek()<remainingTime){
                incStack.push(remainingTime);
            }
        }
        return incStack.size();
        
    }
}
