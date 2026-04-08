class Solution {
    public int evalRPN(String[] tokens) {
        //ICORE?
        //token[i] -> can be opeator or operand? 
                // can operand -ve ? 
                // incase of other how to handle?
                // how to handle num/0 situation?
                // opeand must come after operand -> otherwise invalid
        // tokens -> max length under 2*10^9
         // token[i]
        // edge -> single element return it
      Stack<Integer> stack=new Stack<>();
      for(String token : tokens){
        if(token.equals("+")){
            int b=stack.pop();
            int a=stack.pop();
            stack.push(a+b);
        }else if(token.equals("-")){
            int b=stack.pop();
            int a=stack.pop();
            stack.push(a-b);
        }else if(token.equals("*")){
            int b=stack.pop();
            int a=stack.pop();
            stack.push(a*b);
        }else if(token.equals("/")){
            int b=stack.pop();
            int a=stack.pop();
            stack.push(a/b);
        }else{
            stack.push(Integer.parseInt(token));
        }
      }
      return stack.peek();
    }
}
