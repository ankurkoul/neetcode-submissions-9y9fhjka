class Solution {

    public String encode(List<String> strs) {
        StringBuilder res=new StringBuilder();
        for(String str:strs){
            int l=str.length();
            res.append(""+l+"#"+str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int left=0;
        while(left<str.length()){
            int right=left;
            while(str.charAt(right)!='#'){
                right++;
            }
            int len=Integer.parseInt(str.substring(left,right));
            // move left to next string
            left=right+1+len; //to new integer
            res.add(str.substring(right+1,left));
        }
        return res;
    }
}
