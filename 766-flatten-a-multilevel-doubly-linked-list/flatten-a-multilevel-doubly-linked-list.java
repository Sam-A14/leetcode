/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return null;
        }
        FlattenList(head);
        return head;
    }
    private Node FlattenList(Node curr){
        Node node = curr;
        Node tail = curr;
        while(node!=null){
            Node next = node.next;
            if( node.child !=null){
                Node childHead = node.child;
                Node childTail = FlattenList(childHead);
                node.next = childHead;
                childHead.prev = node;
                childTail.next = next;
                if(next != null){
                    next.prev = childTail;
                }
                node.child = null;
                tail = childTail;
            }else{
                tail = node;
            }
            node = next;

    }
     return tail;
    }
}