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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)return null;
        //check whether it has aleast k nodes
        int count=0;
        ListNode cur=head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        if(count<k){
            return head;
        }
        //if have k nodes
        count=0;
        ListNode prev=null;
        cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
            count++;
            if(count==k)break;
        }
        
        if(cur!=null){
            // means list is still pending
            head.next=reverseKGroup(cur,k);
        }
        return prev;
    }
}
