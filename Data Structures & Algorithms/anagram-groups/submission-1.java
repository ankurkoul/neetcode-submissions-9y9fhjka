class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //a
            // strs cant be empty 
            // length is 1000
            // str[i] is lowercase
            // single is anagram
        //e
         Map<String,List<String>> map=new HashMap<>();
         for(String str: strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            map.computeIfAbsent(key,x->new ArrayList<>()).add(str);
         }
         List<List<String>> res=new ArrayList<>();
         for(List<String> val: map.values()){
            res.add(val);
         }
         return res;
        //s
        //t
    }
}
