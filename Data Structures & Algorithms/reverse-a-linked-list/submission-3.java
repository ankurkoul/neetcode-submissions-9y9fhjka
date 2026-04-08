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
    public ListNode reverseList(ListNode head) {
       
        return recursive(head);
    }

    private ListNode recursive(ListNode head){ 
         //reverse rest and then return // 1->2->3
         if(head ==null || head.next==null)return head;
          ListNode newhead= recursive(head.next); //3 as it base condition
          head.next.next=head; // 1->next ie 2, 2->next= 1
          head.next=null;
          return newhead;
    }

    private ListNode iterative(ListNode head){
        if(head==null)return null;
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}
