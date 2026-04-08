class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        if(strs.length==0)return res;
        Map<String,List<String>>gmap=new HashMap<>();
        for(String str: strs){
            char[]ch=str.toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            gmap.computeIfAbsent(key, x->new ArrayList<>()).add(str);
        }
        
        for(List<String> value: gmap.values()){
            res.add(value);
        }

        return res;
    }
}
