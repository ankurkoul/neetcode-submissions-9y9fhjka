class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         if(strs ==null || strs.length==0)return new ArrayList<>();
         Map<String, List<String>> map=new HashMap<>();
         for(String s: strs){ //O(n)
            char[] schar=s.toCharArray(); //O(k) -> create a new char[] and copy every character from the String into it.
            Arrays.sort(schar); //KlogK 
            String key= String.valueOf(schar); //O(k)  -> creates a new String containing the characters from the array.Again, it has to copy/read all K characters:
            map.computeIfAbsent(key, x-> new ArrayList()).add(s);
         }

         return map.values().stream().collect(Collectors.toList());
    }
    // hence time -> N* (klogK)
    /*
    Time complexity is O(N × K log K), 
        where N is the number of strings and K is the maximum string length. We sort each string to create  
        its canonical anagram key. 
        
        Space complexity is O(N × K) because the HashMap stores up to N distinct sorted keys, 
        each of length up to K.
    */
}
