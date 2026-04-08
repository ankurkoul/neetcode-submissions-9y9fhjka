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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode merged=new ListNode();
        ListNode cur=merged;
        int carry=0;
        while(l1 !=null || l2 !=null){
            int v1=l1==null?0 : l1.val;
            int v2=l2==null?0 : l2.val;

            int res= v1+v2+carry;
            carry=res/10;
            res=res%10;

            ListNode newNode=new ListNode(res);
            cur.next=newNode;

            //update all ptrs
            l1 = l1==null? null : l1.next;
            l2 = l2==null? null : l2.next;
            cur=cur.next;
        }

        if(carry !=0){
            ListNode newNode=new ListNode(carry);
            cur.next=newNode;
        }

        return merged.next;
    }
}
