class Solution {
    public int[] dailyTemperatures(int[] temp) {
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
            while(!stack.isEmpty() && stack.peek()[0]<temp[i]){
                int[] top=stack.pop();
                res[top[1]]=i-top[1];
            }
            stack.push(new int[]{temp[i],i});
        }
        return res;

        //t
        //s
    }
}
