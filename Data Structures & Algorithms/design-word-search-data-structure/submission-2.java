class TrieNode{
    boolean isEnd=false;
    Map<Character,TrieNode> children=new HashMap<>();
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur=root;
        for(char c: word.toCharArray()){
            cur.children.putIfAbsent(c,new TrieNode());
            TrieNode next=cur.children.get(c);
            cur=next;
        }
        cur.isEnd=true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, TrieNode root){
       // char or .
       // in case of . we need to explore all
       TrieNode cur=root;
       for(int i=idx;i<word.length();i++){
        char c=word.charAt(i);
        if(c=='.'){
            //skip current i  and do dfs call for rest of children
            for(TrieNode child: cur.children.values()){
                boolean found= dfs(word,i+1,child);
                if(found)return true;
                else continue;// with next word
            }
            // all children are over
            return false;
        }else{
            TrieNode next=cur.children.get(c);
            if(next==null)return false;
            cur=next;
        }
       }
       return cur.isEnd;
    }
}
