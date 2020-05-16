package ListNode.虚拟头节点;

import ListNode.双指针.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

  

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.

 */
public class SwapNodesInPairs {
    /**
     * 画出图来 很容易看
     */
    public ListNode swapPairs(ListNode head) {
        // 头节点
        ListNode head0 = new ListNode(0);
        head0.next = head;

        ListNode p = head0;
        while (p.next != null && p.next.next != null) {
            ListNode a = p.next;
            ListNode b = a.next;
            ListNode c = b.next;
            b.next = a;
            a.next = c;
            p.next = b;
            p = a;

        }
        return head0.next;

    }
    //25 147 148
}
