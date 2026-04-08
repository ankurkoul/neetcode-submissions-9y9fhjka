class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Edge case: empty list OR no reversal needed
        if (head == null || k == 1) return head;

        // Dummy node helps handle edge case when head changes
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prevGroupEnd always points to node BEFORE current group
        ListNode prevGroupEnd = dummy;

        // We process list group by group
        while (true) {

            /*
             --------------------------------------------------
             STEP 1: Check if there are at least k nodes ahead
             --------------------------------------------------

             Instead of counting entire remaining list (like recursion),
             we just move k steps ahead.

             If we can't reach k nodes → stop processing.
            */
            ListNode kth = prevGroupEnd;

            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // If fewer than k nodes remain, we're done
            if (kth == null) break;

            /*
             --------------------------------------------------
             STEP 2: Reverse exactly k nodes
             --------------------------------------------------

             Current group:
             prevGroupEnd -> groupStart -> ... -> kth -> nextGroupStart

             We reverse nodes from groupStart to kth.
            */

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // Standard reverse logic
            ListNode prev = nextGroupStart; 
            ListNode curr = groupStart;

            // Reverse until we reach nextGroupStart
            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            /*
             After reversal:
             kth becomes new head of this group
             groupStart becomes end of this group
            */

            /*
             --------------------------------------------------
             STEP 3: Connect reversed group with previous part
             --------------------------------------------------
            */

            // Connect previous group to new head (kth)
            prevGroupEnd.next = kth;

            // Move prevGroupEnd to end of current reversed group
            prevGroupEnd = groupStart;

            // Loop continues for next k-group
        }

        return dummy.next;
    }
}