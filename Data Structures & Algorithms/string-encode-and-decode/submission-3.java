class Solution {

    public String encode(List<String> strs) {
        //a
        // Strs length <+=10^9, what string it cant be can use it as delimter
        // approch 1: just use delimiter '#' but we can have its as character
        // aproach 2: use length+'#'
        //b
        if(strs==null || strs.isEmpty())return "";
        //c
        StringBuilder sb=new StringBuilder();
        for(String str: strs){
            //why length before string 
            //so that when we decode we canknow where should we put other pointer
            // eg 3#tea4#snack
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
            List<String> res=new ArrayList<>();
            if(str==null || str.isEmpty())return res;
             //left 
             //right->right will move till find digit  or till not reached #
             //eg 3#tea4#snack
             int left=0,right=0;
             while(left<str.length()){
                while(str.charAt(right)!='#'){
                    right++;
                }
                int len= Integer.parseInt(str.substring(left,right));
                String val=str.substring(right+1,right+len+1);
                res.add(val);
                left=right+len+1;
                right=left;
             }
             return res;

    }
}
