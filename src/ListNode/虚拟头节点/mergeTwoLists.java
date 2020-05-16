package ListNode.虚拟头节点;

/**
 * 两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 */
public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head0 = new ListNode(0);
        ListNode cur = head0;
        ListNode a = l1;
        ListNode b = l2;
        while (a!=null&&b!=null){
            if (a.val<=b.val){
                cur.next = a;
                cur = a;
                a = a.next;
            }else {
                cur.next = b;
                cur = b;
                b = b.next;
            }
        }
        if(a==null){
            cur.next = b;
        }
        if(b==null){
            cur.next = a;
        }
        return head0.next;
    }
}
