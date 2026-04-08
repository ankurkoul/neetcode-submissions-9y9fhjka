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
        if(head==null)return null;
        //a->copya->b-> copyB
        Node cur=head;
        while(cur!=null){
            Node copy=new Node(cur.val);
            Node next=cur.next;
            cur.next=copy;
            copy.next=next;
            cur=copy.next;
        }

        //link copy to random
        Node newHead=head.next;
        cur=head;
        while (cur != null) {
             if (cur.random != null){
                Node copy=cur.next;       //a->acopy
                Node randomCopy=cur.random.next; //eg: a=>d->copyD
                copy.random=randomCopy;
             }
             cur=cur.next.next;
        }

        //de linking
        cur=head;
        while(cur!=null){
            Node copy=cur.next; //a->copyA->b-> copyB
            cur.next=copy.next; //a ->b
             if (copy.next != null) {
                copy.next=copy.next.next; //copyA->copyB
             }
             cur=cur.next;
        }

        return newHead;

    }


    public Node copyRandomList1(Node head) {
        if(head ==null)return null;
        /**
        next:
        a->b->c->d
        
        random:
        a=>d=>b=>c

        before: a==>c
        after:  a==>copyA-->c
        */
  //1st loop     
       Node cur=head;      //a
       while(cur !=null){
        Node copy=new Node(cur.val); //copyA
        copy.next=cur.next; // copyA.next= b  ie copyA->B
        cur.next=copy;      // a.next = copy  ie a->copyA
        cur=copy.next;      // a=b;
       }
       //a->copyA->b->copyB->c->copyC->d->copyD

// 2nd loop
        Node newHead = head.next; // Get the head of the deep copy list (copyA)
        cur = head;          // Start iterating from the original head (a)
        while (cur != null) {
            if (cur.random != null) { // Check if the original node has a random pointer
                cur.next.random = cur.random.next;
                // Explanation:
                // cur.next = copy of the current node (e.g., copyA)
                // cur.random = the random pointer of the original node (e.g., d)
                // cur.random.next = the deep copy of the random node (e.g., copyD)
                // Thus, cur.next.random = copyD
                // copyA.random =copyD;
                // like a=>d
            }
            cur = cur.next.next; // Move to the next original node (skip the deep copy nodes)
            // For example: if cur = a, then cur.next.next = b
        }
     //a=>d=>b=>c
     //copyA=>d.next=copyD
     //copyB=>c.next=copyC
     //copyC=null
     //copyD=>b.next=copyB
     
     // copyA=>copyD=>copyB=>copyC


//3rd lopp
    cur = head; // Start iterating from the original head (a)
    while (cur != null) {
        Node copy = cur.next;  // copy points to the deep copy of cur (e.g., copyA)
        cur.next = copy.next;  // Restore the original node's next pointer (e.g., a->b)
        if (copy.next != null) {
            copy.next = copy.next.next;  // Link the deep copy node to the next deep copy node
        }
        cur = cur.next; // Move to the next original node (e.g., b)
    }

    return newHead;
    }
}
