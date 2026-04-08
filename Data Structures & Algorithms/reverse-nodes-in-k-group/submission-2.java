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
        if(head ==null) return head;
        //check enough nodes
        ListNode cur=head;
        int count=0;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        if(count<k)return head;

        //now enough record hence we can reverse 
        count=0;
        ListNode prev=null;
        cur=head;
        while(cur!=null){
            if(count==k)break;
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
            count++;
        }
        //if it has more elements move to next
        if(cur!=null){
            // since now head is last node hence
            head.next=reverseKGroup(cur,k);
        }
        return prev;

    }
}
