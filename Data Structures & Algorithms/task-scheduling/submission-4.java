class Solution {
    public int leastInterval(char[] tasks, int n) {
        // math approach
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        int maxF=Arrays.stream(count).max().getAsInt();
        int maxCount=0;
        for(int i : count){
            if(maxF==i)
                maxCount++;
        }

        // math formula
        // for 4 A's what will be the gap -> A A A A -> ie 3 as last A dont need gap
        int maxFConsider=maxF-1; // we can skip 1
        /*
        A _ _ A if n is 2
        Distance from first A to next A:
            1 position for A itself
            2 cooldown slots ie 2 
        Total = 3  
        */
        int slot=n+1;
        //What Happens in the Last Row?
        /**
        A A A
        B B B
        n = 2
        
        for As ->
            A _ _ | A _ _ | A
            ie (maxf - 1) * (n + 1) + 1
        now we also have B with same frequency.
            A B _ | A B _ | A B
         ie (maxf - 1) * (n + 1) + 2
         
         sa
        */
        int lastBlock=maxCount; 
        int time=(maxFConsider*slot) + lastBlock;
         return Math.max(tasks.length, time);

    }
}
