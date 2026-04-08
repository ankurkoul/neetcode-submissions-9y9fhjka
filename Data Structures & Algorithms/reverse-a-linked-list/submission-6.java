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
        if(head ==null  || head.next ==null)return head;
        //divide current and rest
        ListNode rest=head.next;
        ListNode newHead= reverseList(rest);
        rest.next=head; //initally head -> rest but now head -> rest and rest -> head
        head.next=null;
        return newHead;
    }
}
