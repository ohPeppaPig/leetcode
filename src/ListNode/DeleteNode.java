package ListNode;

import ListNode.虚拟头节点.ListNode;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。


 */
public class DeleteNode {
    /**
     * 删除需要前一个节点 ，但是该题不能找前一个节点，那就改变值
     * @param node
     */
    public void deleteNode(ListNode node) {

            // 注意: 这个方法对尾节点不适用。题目中要求了给定的node不是尾节点
            // 我们检查node.next, 如果为null则抛出异常, 确保了node不是尾节点
            if(node == null || node.next == null)
                throw new IllegalArgumentException("node should be valid and can not be the tail node.");

            node.val = node.next.val;
            node.next = node.next.next;
    }
}
