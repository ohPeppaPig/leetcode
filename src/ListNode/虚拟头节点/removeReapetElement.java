package ListNode.虚拟头节点;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

 示例 1:

 输入: 1->2->3->3->4->4->5
 输出: 1->2->5

 */
public class removeReapetElement {
    /**
     * 迭代过程中，如果cur.next.val == cur.next.next.val说明此时有重复元素，
     * 此时创建一个临时指针temp，指向cur的下一个节点，即temp指向的第一个重复元素所在的位置。
     * 通过while循环去重，去重后，temp指向的是重复元素中的最后一个位置。
     * 最后cur.next = temp.next就实现了消除重复元素。

     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            //节点相等时进行判断
            if (cur.next.val == cur.next.next.val) {
                //创建重复节点，找到重复节点最后一个
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val ) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            }
            else{
                cur = cur.next;
            }

        }
        return dummy.next;
    }
}
