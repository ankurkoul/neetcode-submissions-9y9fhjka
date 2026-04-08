class Solution {
     public int[] dailyTemperatures(int[] temp) {
        int n= temp.length;
        int[]res=new int[n];
        /*
        [71, 69, 72]
              i   j    here 69< 72 hence res[i]=j-i=1
         i    j        here 71>69 hence move fwd but rather moving j+1
                       we store j+1 ie 1 hence j+1 ie 72 
         i        j    here 71<72  hence res[i]=j-i=2
                       if res[j]==0 means we can move j directly to end
                       means no greater temp
        
        */
        for(int i=n-2; i>=0;i--){ //2nd last 
            int j=i+1; //next warmer day 
            while(j< n && temp[j]<=temp[i]){
                // not greater 
                if (res[j] == 0) {
                    j = n;
                    break;
                }
                j+=res[j];
            }
            //found warmer day
            // j could be greater than n hence check
            if(j<n)
            res[i]=j-i;
        }
        return res;
     }
    public int[] dailyTemperatures2(int[] temp) {
        //a
        // can temp negative?
        // max/min of temp[i] and temp length
        // in case temp is less than 2 then?
        // in case semp temp means no greater should i return 0
        //
        //l
        // montainc decreasing stack,
        // before pushing new [value, idx] check top , if top smaller pop it until smaller
        // while poping update res with [idx, current-idx] 
        // then push new value
        // [30,38,30,36,35,40,28]
        /*
         [30,38,30,36,35,40,28] => i(0)==>push =>q[{30,0}] ,res[]
         [x,38,30,36,35,40,28]  => i(1)==>Greater than top=> pop  =>q[] ,res[0]=[i-0] =1
                                => i(1)==>push =>q[{38,1}] ,res[1]
                                => i(2)==>push =>q[{38,1},{30,2}] ,res[1]
                                => i(3)==Greater than top=> pop =>q[{38,1}] ,res[0=>1,2=>i-2=1
                                => i(3)==>push =>q[{38,1},{36,3}] ,res[0=>1,2=>i-2=1]
                                => i(4)==>push =>q[{38,1},{36,3},{35,4}] ,res[0=>1,2=>i-2=1    
                                => i(5)==>Greater than top=> pop =>q[{38,1},{36,3},{35,4}] ,res[0=>1,2=>i-2=1 ,4=>5-4, 3=>5-3, 1=5-1  
                                => i(5)==>push =>q[40,5]
                                => i(6)--> push=> q[{40,5}, {28,6}]
        */
        if(temp.length<=1)return new int[]{};
        int n= temp.length;
        int[]res=new int[n];
        Deque<int[]> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            //check stack top {val,idx}
            int t=temp[i];
            //The while loop does not repeatedly revisit the same elements. 
            // Once an element is popped, it is permanently removed and never revisited.
    
            while(!stack.isEmpty() && stack.peek()[0]<t){
                int[] top=stack.pop();
                res[top[1]]=i-top[1];
            }
            stack.push(new int[]{t,i}); //O(1)
        }
        return res;

        //t: for: O(n) for each item we perform 2 task push o(1) or pop rest of item
        //Total Operations:
/* Pushing happens 
n times (one for each element).
Popping happens at most n times because an element is popped only once and not pushed back.*/
        //s
    }
}
