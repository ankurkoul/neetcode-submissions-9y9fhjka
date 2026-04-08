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
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode prevGroupEnd=dummy;
        while(true){
            //check have k nodes
            ListNode kth=prevGroupEnd; //start from previous last node
            for(int i=0; i<k && kth!=null; i++ ){
                kth=kth.next;
            }
            //if kth is null means less node
           if (kth == null) break;

            //we have enough nodes we can do normal reverse
            /*
            Current group:
             prevGroupEnd -> groupStart -> ... -> kth -> nextGroupStart

             We reverse nodes from groupStart to kth.

             why we need groupStart and nextgroupstart
             prevGroupEnd → 1 → 2 → 3 → 4 → 5
             after reverse
             prevGroupEnd → 3 → 2 → 1 → 4 → 5 hence postion of 1 node is lost

             Similary kth will change
            */
             ListNode groupStart = prevGroupEnd.next;
             ListNode nextGroupStart = kth.next;

             //now reverse
            ListNode prev = null;
            ListNode curr = groupStart;

            while (curr != nextGroupStart) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            //after reversal prev is new head of group
            // reconnect
            prevGroupEnd.next = prev;          // connect previous part
            groupStart.next = nextGroupStart; // connect tail to next part

            // move pointer forward
            prevGroupEnd = groupStart;
            

        }
        return dummy.next;
    }
}
