class LRUCache {
    class Node{
        int key,value;
        Node prev,next;

        Node(int key,int value){
            this.key=key;
            this.value = value;
        }
    }
    
    HashMap<Integer,Node>map;
    Node head , tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next =tail;
        tail.next = head;
    }
    void addFirst(Node node){
        Node first = head.next;
        node.next=first;
        node.prev=head;
        head.next=node;
        first.prev=node;
    }
    void remove(Node node){
        Node prev=node.prev;
        Node next = node.next;
        prev.next=next;
        next.prev=prev;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        remove(node);
        addFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
       if(map.containsKey(key)){
        Node node=map.get(key);
        node.value=value;
        remove(node);
        addFirst(node);
        return ;
       } 
       Node node = new Node(key,value);
       map.put(key,node);
       addFirst(node);
       if(map.size()>capacity){
        Node lru =tail.prev;
        remove(lru);
        map.remove(lru.key);
       }  
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */