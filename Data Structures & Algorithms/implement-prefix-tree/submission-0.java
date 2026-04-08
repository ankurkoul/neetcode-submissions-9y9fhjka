class TrieNode{
    boolean isEnd=false;
    Map<Character,TrieNode> children=new HashMap<>();
}

class PrefixTree {
    private TrieNode root;


    public PrefixTree() {
         root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            cur.children.putIfAbsent(c,new TrieNode());
            //move cur to this node
            cur=cur.children.get(c);
        }
        cur.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode cur=root;
        for(char c: word.toCharArray()){
           TrieNode next= cur.children.get(c);
           if(next==null)return false;
           cur=next;
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        for(char c: prefix.toCharArray()){
            TrieNode next=cur.children.get(c);
            if(next==null)return false;
            cur=next;
        }
        return true;
    }
}
