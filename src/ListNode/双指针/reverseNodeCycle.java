package ListNode.双指针;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: 1->2->3->4->5->NULL, k = 2
 输出: 4->5->1->2->3->NULL
 解释:
 向右旋转 1 步: 5->1->2->3->4->NULL
 向右旋转 2 步: 4->5->1->2->3->NULL

 */
public class reverseNodeCycle {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0){
            return head;
        }
        ListNode tail = head;
        int count = 1;
        while (tail.next!=null){
            tail = tail.next;
            count++;
        }
        // 此处考虑循环
        k = k % count;
        if (k == 0) {
            return head;
        }
        ListNode p = head;
        for(int i = 0;i<count-k-1;i++){
            p = p.next;
        }
        ListNode newNode = p.next;
        p.next = null;
        tail.next = head;
        return newNode;
    }
}
