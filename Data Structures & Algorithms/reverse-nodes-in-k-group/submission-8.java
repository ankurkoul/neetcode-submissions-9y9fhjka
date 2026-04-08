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
        if(head==null || k==0)return head;
        //We use a dummy node to handle edge cases where the head of the list changes after reversing the first group.
        // It simplifies pointer manipulation and avoids special handling for the first group.
        // create dummy node to handle movements
        //check enough nodes
        //reverse
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode prevGroupLast=dummy;
        while(true){
            ListNode kth=prevGroupLast;
            for(int i=0;i< k && kth!=null;i++){
                kth=kth.next;
            }
            // if kth is null means less node
            if (kth == null) break;

            // enought node hence go with reverse but before reverse save ptr as they will change
            // prevGroupLast -> groupStart---> kth-->nextGroupStart
            //after revvers
            // prevGroupLast → (new head of reversed group) → ... → groupStart → nextGroupStart
            ListNode groupStart=prevGroupLast.next;
            ListNode nextGroupStart=kth.next;
            ListNode prev=null;
            ListNode cur=groupStart;
            while(cur!=nextGroupStart){
                ListNode next=cur.next;
                cur.next=prev;
                prev=cur;
                cur=next;
            }
            //update list which we have break
            prevGroupLast.next=prev; //// connect previous part to new head
            groupStart.next=nextGroupStart; // connect tail to next group

            //move to next group
            // prevGroupLast.next -> point to prev head hence groupStart was orginally head
            prevGroupLast=groupStart;
        }

        return dummy.next;
    }
}
