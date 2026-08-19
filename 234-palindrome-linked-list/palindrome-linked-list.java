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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next ==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode SecondHalf = reverse(slow);
        ListNode FirstHalf = head;
        while(SecondHalf != null){
            if(SecondHalf.val != FirstHalf.val){
                return false;
            }
            SecondHalf = SecondHalf.next;
            FirstHalf = FirstHalf.next;
        }
        return true;
    }
      ListNode reverse(ListNode head){
            ListNode prev = null ;
            ListNode curr = head;
            while(curr!=null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr=next;
            }
             return prev;
      }

}