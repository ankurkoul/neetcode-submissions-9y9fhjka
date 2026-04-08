class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //boundary 
        //ICORE pattern: input validation / constriants /output format /rules/assumptions /edge
        // 1. Input validity
            // strs -> can be empty/null ?
            //      -> max size  of strs
            // strs[i] ->  max size  of strs[i]
            //         -> can be what case ? if multi case what is case sensitivity?
        // 2.Constraint -> size discussion of str
        //output -> grouping as list<list> , invalid case wht to return
        // rules -> basedon discussion str must be not null or within range or lowercase
        // edge -> "", "a"
        //i
        if(strs ==null || strs.length==0)return new ArrayList<>();
        List<List> res=new ArrayList<>();
        Map<String,List<String>> map =new HashMap<>();
        for(String str: strs){
            char[] key=str.toCharArray();
            Arrays.sort(key);
            String keyStr=String.valueOf(key);
            map.computeIfAbsent(keyStr, x->new ArrayList<>()).add(str);
        }

        return map.values().stream().collect(Collectors.toList())  ;

    }
}
