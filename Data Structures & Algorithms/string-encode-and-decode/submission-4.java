class Solution {

    public String encode(List<String> strs) {
        //ICORE
        /*
        input -> strs is null / empty then return ""?
             -> str[i] will be english el or special cha
             -> case -> either then case senstivity
        const -> max size of strs and length ofstr[i]
        output-> invalid empty so string both
        */
        if(strs ==null || strs.isEmpty())return "";
        StringBuilder sb=new StringBuilder();
        for(String str: strs){
            int l=str.length();
            sb.append(l).append('#').append(str); //3#abc2#ab
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res=new ArrayList<>();
        int l=0,r=0;
        while(r<str.length()){
            while(str.charAt(r)!='#'){
                r++;
            }
            String lenStr= str.substring(l,r);
            int len=Integer.parseInt(lenStr);
            String sub=str.substring(r+1, r+len+1);
            res.add(sub);
            l=r+len+1;
            r=l;

        }

        return res;

    }
}
