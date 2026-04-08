class MinStack {
    //a
        // in case of empty? return exception or value?
        // do duplicates need to be handled ?
        // int val min/max range? can int is enough
        // multi threading need be considered?
    private final Stack<int[]>stack=new Stack<>(); 
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val,val});
        }else{
            stack.push(new int[]{
                val,
                Math.min(val,stack.peek()[1])
                });
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
         return stack.peek()[1];
    }
}
