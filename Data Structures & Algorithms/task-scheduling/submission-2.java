class Solution {
    public int leastInterval(char[] tasks, int n) {
        // find task -> have most remaining occurance -> hardest to fit -> more slots+ cooldown
        // maxHeap -> to select task with max remaining count
        // Queue ->a task can re executed after n cooldown -> currentTime+n;
        // when cooldown is over push to maxHeap
        // if heap is empty we can jump timer to load task from queue
        int[] count=new int[26];
        for(char task  :   tasks){
            count[task-'A']++;
        }

        //load task in heap
        Queue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for( int c  :   count){
            if(c>0){
                maxHeap.offer(c);
            }
        }

        int time=0;
        Queue<int[]>coolDownQ=new ArrayDeque<>();
        while(!maxHeap.isEmpty() || !coolDownQ.isEmpty()){
             //procecssing started time++;
            time++;
            if(!maxHeap.isEmpty()){
                int top=maxHeap.poll();
                top--;
                if(top!=0){
                    //consider for next processing after cooldown
                    coolDownQ.add(new int[]{top, time+n});
                }
            }
            if(!coolDownQ.isEmpty()){
                int[] top=coolDownQ.peek();
                if(time>=top[1]){
                    maxHeap.offer(coolDownQ.poll()[0]);
                }
            }

        }


        return time;
    }
}
