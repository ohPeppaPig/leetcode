package ListNode;

public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode p = head;
        ListNode fast = head;
        ListNode slow = head;
        // 找到中点
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 逆序
        slow = slow.next;
        ListNode pre = null;
        while(slow!=null){
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // 比较
        while(pre!=null){
            if(pre.val != p.val){
                return false;
            }
            pre = pre.next;
            p = p.next;
        }
        return true;
    }
}
