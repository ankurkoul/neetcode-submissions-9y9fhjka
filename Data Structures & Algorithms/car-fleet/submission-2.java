class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
            //a:
            // input q:
                // integer pos,speed,target can be -ve?
                // if length is less than n?
                // p[i]-> in miles
                // s[i]-> in mile per hour
                // target -> in miles
                // all cars moving in same direction?
                // max value of n ? can it be more 10^1
                // are positions sorted?
            //edge case:
                // 1 car --> is fleet
                // 0 car --> is fleet

            // c1,c2 -> time to reach destination
            // [2,1] -> here c2 will reach in 1 hour, after 1hour c1 will reach hence no fleet
            // [1,2]-> here c2 will reach in 2 hour hence c1 need to be part of fleet
            // [1,1] -> how cars reaching destination treated?
            // hence time to reach is key?
            // if new time value is greater than add to stack hence montonic increasing stack
        //l
            // have map with postition in decreasing order
            // postition -> speed
            // if from back ,
            // if new car merged time is smaller means merge hence we can consider old car time
            // if new car merge time is greater it will have its own fleet
        //c
            Map<Double,Integer> map=new TreeMap<>();
            int n= position.length;
            for(int i=0;i<n;i++){
                map.put((double)(target-position[i]),speed[i]); //logN
            }
            //NlogN

            Deque<Double> stack=new ArrayDeque<>(); // ts: concurrentLinkedDeque/LinkedBlockingQue : putLast
            for(Map.Entry<Double,Integer> e: map.entrySet()){ // in-order-traversal is O(N)
                double newCarRemainingTimeToReach= (double)(e.getKey())/e.getValue(); //O(1)
                // if new car time is smaller than stack car: no merge 
                // if new car time is grater than diff stack
                if(stack.isEmpty()|| stack.peek()<newCarRemainingTimeToReach){
                    stack.push(newCarRemainingTimeToReach);//O(1)
                }
            }// O(N)
            return stack.size();

        //t:
        //  each inseration in treemap is nlogn 
        //  as treeMap is RedBlackTree : balanced binary tree
        //  put,get, remove is logN where n is no of nodes starting from root
        // 
        //s 
    }
}
