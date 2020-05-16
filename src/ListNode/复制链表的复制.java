package ListNode;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class 复制链表的复制 {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>(16);
        Node p = head;
        while (p!=null){
            Node node = new Node(p.val);
            map.put(p,node);
            p = p.next;
        }
        p = head;
        while (p!=null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);



    }
}
