class Solution {
//a
//e
//t
//s
    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String s: strs){
            int l=s.length();
            sb.append(""+l+"#"+s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String>res=new ArrayList<>();
        int left=0;
        while(left<str.length()){
            int right=left;
            while(str.charAt(right)!='#'){
                right++;
            }
            int l=Integer.parseInt(str.substring(left,right));
            // move left to next integer value;
            // 2#ab3#
            //  r  l  
            left=right+l+1;
            res.add(str.substring(right+1,left));
        }

        return res;
    }
}
