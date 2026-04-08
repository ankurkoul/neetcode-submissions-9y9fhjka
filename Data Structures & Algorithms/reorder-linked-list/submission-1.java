/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
       ListNode fast=head , slow=head;
       while(fast!=null && fast.next!=null){
        fast=fast.next.next;
        slow=slow.next;
       } 
       // now slow is in middle
       ListNode prev=null;
       ListNode cur=slow;
       while(cur!=null){
        ListNode next=cur.next;
        cur.next=prev;
        prev=cur;
        cur=next;
       }
       //middle list reveresed
       ListNode merged=new ListNode();
       cur=merged;
       fast=head; // one pointer at begining
       slow=prev; // one pointer at reverse list
       int i=0;
       while(fast!= null && slow!=null){
        if(i%2==0){
            cur.next=fast;
            fast=fast.next;
        }else{
            cur.next=slow;
            slow=slow.next;
        }
        cur=cur.next;
        i++;
       }
    }
}
