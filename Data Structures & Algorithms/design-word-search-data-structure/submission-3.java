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
            cur.children.putIfAbsent(c, new TrieNode());
            cur=cur.children.get(c);;
        }
        //all character added
        cur.isEnd=true;
    }

    public boolean search(String word) {
        //in case of valid char we go normal trie search 
        // in case of . we need to do dfs
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int startIdx, TrieNode root){
        TrieNode cur = root;
         for (int i = startIdx; i < word.length(); i++) {
            char c = word.charAt(i);
             if (c == '.'){
                // it could be any char
                // search all children
                for (TrieNode child : cur.children.values()){
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;

             }else{
                 TrieNode next=cur.children.get(c);
                 if(next==null) return false;
                 cur=next;
             }
         }
         return cur.isEnd;
    }
}
