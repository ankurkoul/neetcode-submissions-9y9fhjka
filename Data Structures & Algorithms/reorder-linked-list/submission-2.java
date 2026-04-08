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
        // 1️⃣ Find middle
       while(fast!=null && fast.next!=null){
        fast=fast.next.next;
        slow=slow.next;
       } 
       // now slow is in middle
       // 2️⃣ Cut and reverse second half
        ListNode cur=slow.next; //reversed node start
        slow.next =null; //cut
        ListNode prev = null;
       while(cur!=null){
        ListNode next=cur.next;
        cur.next=prev;
        prev=cur;
        cur=next;
       }
       //middle list reveresed
        // 3️⃣ Merge two halves
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next=second; //1 ->6
            second.next=tmp1; // 6 -> 2

            //update first and second
            first=tmp1;
            second=tmp2;

        }
    }
}
