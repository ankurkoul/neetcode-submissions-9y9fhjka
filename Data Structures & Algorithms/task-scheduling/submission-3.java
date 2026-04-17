class Solution {
    public int leastInterval(char[] tasks, int n) {
        // find task -> have most remaining occurance -> hardest to fit -> more slots+ cooldown
        // maxHeap -> to select task with max remaining count
        // buffer ->a task can re executed after n cooldown -> currentTime+n;
        // when cooldown is over push to maxHeap
        // if heap is empty we can jump timer to load task from queue

        int[]count=new int[26];
        for(char t: tasks){
            count[t-'A']++;
        }

        Queue<Integer> countMaxHeap=new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]>buffer=new ArrayDeque<>();
       
        //load all task into heap
        for(int c: count){
            if(c!=0)
                countMaxHeap.offer(c);
        }
         int time=0;
        //start processing
        while(!countMaxHeap.isEmpty() || !buffer.isEmpty()){
            //item to processed hence processing
            time++;
            if(!countMaxHeap.isEmpty()){
                int maxRepeatCount  = countMaxHeap.poll();
                maxRepeatCount--;
                if(maxRepeatCount!=0)
                    buffer.add(new int[]{maxRepeatCount, time+n});
            }
            if(!buffer.isEmpty()){
                int[] oldestWaitingTask= buffer.peek();
                int waitingTime= oldestWaitingTask[1];
                if(waitingTime<=time){
                   countMaxHeap.offer(buffer.poll()[0]); 
                }
            }
        }
        return time;
    }
}