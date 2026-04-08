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
        if(head ==null ||head.next ==null)return head; //return leafnode
        //reverse rest and then fix pointer for current
        //recursively we go to last node and lastnode bcm new head
        //in backtrack each node points towards the caller
        // finaly we set original head next to null
        ListNode newHead =reverseList(head.next);
        head.next.next = head;
        head.next=null;
        return  newHead;
    }
}
