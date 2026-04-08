class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))return 0;
        // build dic : pattern -> words
        Map<String,List<String>> map=new HashMap<>();
        for(String w: wordList){
            for(int i=0;i<w.length();i++){
                String pattern=w.substring(0,i)+"*"+w.substring(i+1);
                map.computeIfAbsent(pattern,x->new ArrayList<>()).add(w);
            }
        }
        //start bfs with begin word
        Queue<String> q=new ArrayDeque<>();
        q.offer(beginWord);
        int level=0;
        Set<String> set=new HashSet<>();
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String w= q.poll();
                if(w.equals(endWord))return level+1;
                 for(int i=0;i<w.length();i++){
                    String pattern=w.substring(0,i)+"*"+w.substring(i+1);
                    for(String next: map.getOrDefault(pattern,Collections.emptyList())){
                        if(set.contains(next))continue;
                        set.add(next);
                        q.offer(next);
                    }
                 }
            }
            level++;
        }
        return 0;
    }
}
