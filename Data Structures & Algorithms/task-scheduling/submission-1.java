class Solution {
    public int leastInterval(char[] tasks, int cooldown) {
        Map<Character,Integer> map=new HashMap<>();
        for(char t: tasks){
            map.put(t, map.getOrDefault(t,0)+1);
        }

        //load freq number into maxHeap
        Queue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int v: map.values()){
            maxHeap.offer(v);
        }

        //add buffer queue to allow task to wait after cooldown
        Queue<int[]> buffer=new ArrayDeque<>();
        int time=0;

        while(!maxHeap.isEmpty() || !buffer.isEmpty()){
            //procecssing started time++;
            time++;
            if(!maxHeap.isEmpty()){
                int maxValue=maxHeap.poll();
                maxValue--;
                if(maxValue>0){
                    //consider for next processing after cooldown
                    buffer.offer(new int[]{ maxValue, time+cooldown});
                }
            }
            if(!buffer.isEmpty()){
                int[] oldestTaskEntry= buffer.peek();
                int oldestTaskWaitingTime=oldestTaskEntry[1];
                if(oldestTaskWaitingTime<= time){
                    oldestTaskEntry= buffer.poll();
                    maxHeap.offer(oldestTaskEntry[0]);
                }
            }
        }

        return time;

    }
}
