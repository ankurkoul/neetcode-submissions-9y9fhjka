class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))return 0;
        //prepare dic
        Map<String,List<String>>dic=new HashMap<>();
        for(String w: wordList){
            for(int i=0;i<w.length();i++){
                String pattern= w.substring(0,i) +"*" +w.substring(i+1);
                dic.computeIfAbsent(pattern,x->new ArrayList<>()).add(w);
            }
        }
        Queue<String> q=new ArrayDeque<>();
        q.offer(beginWord);
        Set<String> set=new HashSet<>();
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String top=q.poll();
                if(top.equals(endWord))return level+1;
                for(int i=0;i<top.length();i++){
                    String pattern= top.substring(0,i) +"*" +top.substring(i+1);
                    for(String next: dic.getOrDefault(pattern,Collections.emptyList())){
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
