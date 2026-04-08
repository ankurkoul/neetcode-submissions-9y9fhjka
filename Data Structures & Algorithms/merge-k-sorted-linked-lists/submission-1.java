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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)return null;

        //divide list into 2 halfs, until single elmenent is left
        // list1 : first and middle
        // list2 : middle+1 and last
        // continue until not divide 
        // and then merge
        return divide(lists,0,lists.length-1);
    }
    private ListNode divide(ListNode[]lists, int l, int r){
        if(l==r)return lists[l];
        int mid=l+(r-l)/2;
        ListNode left=divide(lists,l,mid);
        ListNode right=divide(lists,mid+1,r);
        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right ){
        ListNode dummy=new ListNode();
        ListNode cur=dummy;
         while(left!=null && right!=null){
            if(left.val<right.val){
                cur.next=left;
                left=left.next;
            }else{
                cur.next=right;
                right=right.next;
            }
            cur=cur.next;
        }
        if(left!=null){
            cur.next=left;
        } if(right!=null)
             cur.next=right;
        return dummy.next;
    }
}
