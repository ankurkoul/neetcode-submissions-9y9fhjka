class Solution {
    //A
        // operands max value?
        // operands can be negative?
        // max size of tokens
        // empty tokens return value or exception?
        // tokens handle special chars?
        // +ve division behaves the same in both truncating and floor division.
        // -ve division differs: truncation toward zero rounds closer to zero (less negative), 
        // whereas floor division rounds away from zero (more negative).

    private final Deque<Integer>stack=new ArrayDeque<>();
    // thread : CLQ or LBQ
    public int evalRPN(String[] tokens) {
        if(tokens.length==0) return 0;
        for(String t: tokens){
            if(t.equals("+")){
                int a= stack.pop();
                int b= stack.pop();
                stack.push(a+b);
            }else  if(t.equals("-")){
                int a= stack.pop();
                int b= stack.pop();
                stack.push(b-a);
            }else  if(t.equals("*")){
                int a= stack.pop();
                int b= stack.pop();
                stack.push(a*b);
            }  else if (t.equals("/")) {
                int a= stack.pop();
                int b= stack.pop();
                stack.push(b/a);
            } else{
                 stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
