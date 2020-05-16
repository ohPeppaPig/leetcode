package ListNode;

public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        // 最少两个才能环形
        if(head == null || head.next ==null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=slow){
            // 保证fast的后后节点不为空
            if(fast.next == null||fast.next.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
