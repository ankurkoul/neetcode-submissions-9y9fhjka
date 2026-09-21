class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         if(strs ==null || strs.length==0)return new ArrayList<>();
         Map<String, List<String>> map=new HashMap<>();
         for(String s: strs){
            char[] schar=s.toCharArray(); //O(k)
            Arrays.sort(schar); //KlogK
            String key= String.valueOf(schar); 
            map.computeIfAbsent(key, x-> new ArrayList()).add(s);
         }

         return map.values().stream().collect(Collectors.toList());
    }
}
