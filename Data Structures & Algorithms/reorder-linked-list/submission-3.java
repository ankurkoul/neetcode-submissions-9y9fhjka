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
        ListNode fast=head;
        ListNode slow=head;
        // 1 -> get middle node
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //slow is middle
        //2 -> break list form middle and do reverse 
        ListNode cur=slow.next;
        slow.next=null;
        ListNode prev=null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }

        //3->now we need to merge them
        ListNode first=head; //list1
        ListNode second=prev; //list2

        while(first !=null && second!=null){
            ListNode temp1=first.next;
            ListNode temp2=second.next;

            first.next=second;
            second.next= temp1;

            first=temp1;
            second=temp2;
        }
       
    }
}
