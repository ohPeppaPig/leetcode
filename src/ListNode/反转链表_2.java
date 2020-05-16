package ListNode;

import java.util.List;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

 说明:
 1 ≤ m ≤ n ≤ 链表长度。

 示例:

 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 输出: 1->4->3->2->5->NULL

 */
public class 反转链表_2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 找到前驱节点
        ListNode pre = dummy;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode p = null;
        ListNode cur = pre.next;
        for (int i = 0; i <n-m+1 ; i++) {
            ListNode next = cur.next;
            cur.next = p;
            p = cur;
            cur = next;
        }
        // 此时：p为逆序节点的最后一个
        // head为tail节点
        pre.next.next = cur;
        pre.next = p;
        return dummy.next;
    }
}
