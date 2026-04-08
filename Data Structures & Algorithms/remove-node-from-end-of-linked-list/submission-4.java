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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       if(head==null)return head;
       //we need dummy node bcz we need to handle switch where we are deleting head only 
       ListNode dummy=new ListNode();
       dummy.next=head;

       //2 pointers -> fast and seconf
      ListNode fast=head;
      while(n-- >0){
        fast=fast.next;
      }
      
      ListNode slow= dummy; // not head rather dummy so that we can one behind target node
      while(fast!=null){
        fast=fast.next;
        slow=slow.next;
      }
      //reach parent of target node
      slow.next=slow.next.next;
      return dummy.next; // return dummy next handle in case head is removed
    }
}
