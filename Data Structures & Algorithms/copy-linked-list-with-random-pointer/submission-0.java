/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head ==null)return null;
        /**
original        [a]       [b]   [c]        [d]
                n:b      n:c    n:d        n:null
                r:d      r:c    r:null      r: b

loop            [a]          [b]            [c]          [d]
                n:b          n:c            n:d         n:null
                r:copyA      r:copyB        r:copyC      r: copyD

copy            [a]           b               c             d
                n:c          n:d             n:null         n:a
        
        next:
        a->b->c->d
        
        random:
        a=>d=>b=>c

        before: a==>c
        after:  a==>copyA-->c
        */
       
       Node cur=head;      //a
       while(cur !=null){
        Node copy=new Node(cur.val); //copyA
        copy.next=cur.next; // copyA.next= b  ie copyA->B
        cur.next=copy;      // a.next = copy  ie a->copyA
        cur=copy.next;      // a=b;
       }
       //a->copyA->b->copyB->c-> copyC->d->copyD

       Node newHead=head.next; //copyA
       cur=head;               //a
       while(cur!=null){
        if(cur.random !=null){//d
            cur.next.random=cur.random.next;  
                                    // cur.next=copyA & cur.random=d
                                    // copyA.random=d.next 
                                    //  ie copyA=> d.next 
                                    //  ie copyA=> null  
        }
        cur=cur.next.next ;// b ie cur=copy.next ie cur=b
       }
     //a=>d=>b=>c
     //copyA=>d.next=null
     //copyB=>c.next=d
     //c.random==null // hence skip
     //copyD=>b.next=c

    cur=head;
    while(cur!=null){
        Node copy=cur.next; //copyA
        cur.next=copy.next; //a->b
        if(copy.next!=null){
            copy.next=copy.next.next; //copyA->b.next ie copyA->copyB
        }
        cur=cur.next; // a=b;
    }
    return newHead;
    }
}
