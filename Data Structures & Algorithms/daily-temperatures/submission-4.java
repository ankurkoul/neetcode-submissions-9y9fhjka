class Solution {
    public int[] dailyTemperatures(int[] temp) {
        if(temp==null || temp.length<=1)return new int[]{};
        int n=temp.length;
        int[]res=new int[n];
        Deque<int[]> decStack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            int current=temp[i];
            while(!decStack.isEmpty() && decStack.peek()[0]< current){
                //mean new value is bigger than old 
                int[] top=decStack.pop();
                res[top[1]]=i-top[1];
            }
            decStack.push(new int[]{current, i});
        }
        return res;
    }
}
