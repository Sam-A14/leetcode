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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
         if(head==null || head.next==null |  head.next.next==null){
            return new int[]{-1,-1};
         }
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;
        int firstCritical = -1;
        int  previousCritical = -1;
        int minDist = Integer.MAX_VALUE;
        int maxDist = 0;
        while(curr.next!=null){
            Boolean isCritical = (curr.val>prev.val && curr.val>curr.next.val) ||(curr.val<prev.val && curr.val<curr.next.val);
            if(isCritical){
                 if(firstCritical==-1){
                 firstCritical = index;
                 previousCritical = index;
            }else{
                int distance = index-previousCritical;
                minDist =Math.min(minDist,distance);
                 previousCritical = index;
            }
            maxDist = index- firstCritical;
            }
           prev = curr ;
           curr=curr.next;
           index++;
        }
        if(minDist == Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        return new int[]{minDist , maxDist};
    }
}