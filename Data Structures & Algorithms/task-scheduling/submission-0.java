class Solution {
    public int leastInterval(char[] tasks, int cooldown) {
        // each task has idle time , hence if process freq task first we can have cover up its ideal time
        // here rather task there count matters 
        Map<Character,Integer> map=new HashMap<>();
        for(char t: tasks){
            map.put(t, map.getOrDefault(t,0)+1);
        }
        // now get only values -> choose most freq or most time executed
        Queue<Integer> maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        //Collections.reverseOrder();
        for(int v: map.values()){
            maxHeap.offer(v);
        }
        
        int time=0;
        // in case of cooldown , add task to queue
        Queue<int[]> buffer =new ArrayDeque<>();
        while(!maxHeap.isEmpty() || !buffer.isEmpty()){
            //start processing
            if(!maxHeap.isEmpty() ){
                int topFreq=maxHeap.poll();
                //processed hence 1 count
                topFreq--;
                //add this top to waitng queue for time+cooldown
                if(topFreq>0){
                    buffer.add(new int[]{topFreq, time+cooldown});
                }
            }
            if(!buffer.isEmpty()){
               // queue first element : time is less than current
               int[] oldestTime= buffer.peek();
               int waitingTime =oldestTime[1];
               //check current time is equal or greater than waiting time
               // as less it can be processed yet 
               // to process add it into queue
               if(time>= waitingTime){
                  maxHeap.add(buffer.poll()[0]);
               }
            }
            time++; // move to next interval
        }
        return time;
    }
}
