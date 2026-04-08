class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //l
        /*
        Map<pattern,[words]>
        iterate over strs : i=0 to n
        1. convert str into pattern -> str : tocharArray() : Arrays.sort()
        2. check if map.computeIfAbsent(pattern , x-> new Al ).put(str)
        3. iterate over map.values and insert value into list
        */
        // range of string[] under 10^9
        // range of str under 10^9
        // lowercase ? <- missed this
        if(strs==null || strs.length==0)return new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(String s: strs){
            char[] sc=s.toCharArray();
            Arrays.sort(sc);
            String pattern=String.valueOf(sc);
            map.computeIfAbsent(pattern , x-> new ArrayList<>() ).add(s);
        }
        List<List<String>> res=new ArrayList<>();
        for(List<String> v: map.values()){
            res.add(v);
        }
        return res;
    }
}
