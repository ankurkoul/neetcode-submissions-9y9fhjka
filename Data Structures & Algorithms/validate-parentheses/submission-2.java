class Solution {
    public boolean isValid(String s) {
     //a
     // if non bracket then return false
     // 
     //l
     if(s.isEmpty())return true;
     ArrayDeque<Character> stack=new ArrayDeque<>();
     for(char c: s.toCharArray()){
        if("({[".contains(""+c)){
            stack.push(c);
        }else{
            if(stack.isEmpty())return false;
           if(c==')'&& stack.peek()!='(')return false;
           if(c=='}'&& stack.peek()!='{')return false;
           if(c==']'&& stack.peek()!='[')return false;
           stack.pop();
        }
     }
     return stack.isEmpty();
    }
}
