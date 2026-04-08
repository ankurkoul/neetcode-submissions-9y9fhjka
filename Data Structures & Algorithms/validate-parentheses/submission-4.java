class Solution {
    public boolean isValid(String s) {
        //a
            // do we need check for other chars like special 
            // empty string?
            // max length of string?
            //
        //l
            //Stack : where add char if open bracket
            // if char is closed bracket, pop stack char
           
            if(s.isEmpty())return true;
            if(s.length()<2)return false;
            Deque<Character> stack=new ArrayDeque<>();
            for(char c: s.toCharArray()){
                if(c=='('|| c=='{' || c=='['){
                    stack.push(c);
                }else{
                    if(stack.isEmpty())return false;
                    if(c==')' && stack.pop()!='(')return false;
                    if(c=='}' && stack.pop()!='{')return false;
                    if(c==']' && stack.pop()!='[')return false;
                }
            }
            return stack.isEmpty();
        //t
        //s
    }
}
