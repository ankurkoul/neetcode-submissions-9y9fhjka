class Solution {
    public boolean isValid(String s) {
       //ICORE 
        if(s==null || s.isEmpty())return true;
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if("({[".contains(""+c)){
                stack.push(c);
            }
            else if(stack.isEmpty())return false;
            else if(c==')' && stack.peek()!='(')return false;
            else if(c=='}' && stack.peek()!='{')return false;
            else if(c==']' && stack.peek()!='[')return false;
            else stack.pop();
        }
        return stack.isEmpty();
    }
}
