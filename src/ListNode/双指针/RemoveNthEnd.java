package ListNode.双指针;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.

 */
public class RemoveNthEnd {
    /**
     * 双指针，固定移动位置
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode head0 = new ListNode(0);
        head0.next = head;

        ListNode a = head0;
        ListNode b = head0;
        for(int i = 0;i<n+1;i++){
            b = b.next;
        }
        while(b!=null){
            a = a.next;
            b = b.next;

        }
        a.next = a.next.next;
        return head0.next;

    }

    //61 143 234
}
