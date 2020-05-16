package ListNode.虚拟头节点;

import ListNode.双指针.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。

 示例:

 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 */
public class RemoveListElements {
    /**
     * 使用虚拟头节点，不然删除节点为头节点难处理
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode head0 = new ListNode(0);
        head0.next = head;
        ListNode cur = head0;
        while(cur.next!=null){
            if(cur.next.val == val){
                ListNode del = cur.next;
                cur.next = del.next;
                del.next = null;
            }else{
                cur = cur.next;
            }
        }
        return head0.next;
    }


    // 82 21
}
