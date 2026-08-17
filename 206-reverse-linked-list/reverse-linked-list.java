class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // Store next node
            curr.next = prev;              // Reverse current node's pointer
            prev = curr;                   // Move prev forward
            curr = nextTemp;               // Move curr forward
        }

        return prev; // prev is the new head
    }
}