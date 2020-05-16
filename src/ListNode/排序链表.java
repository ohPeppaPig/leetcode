package ListNode;

public class 排序链表 {
    // 归并排序
    public ListNode sortList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(temp);
        return sortMerge(l1,l2);
    }

    private ListNode sortMerge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1!=null){
            p.next = l1;
        }
        if(l2!=null){
            p.next = l2;
        }
        return dummy.next;
    }

    public ListNode sortList2(ListNode head) {
        if(head==null||head.next==null) return head;
        // 没有条件，创造条件。自己添加头节点，最后返回时去掉即可。
        ListNode newHead=new ListNode(-1);
        newHead.next=head;
        return quickSort(newHead,null);
    }
    // 带头结点的链表快速排序
    private ListNode quickSort(ListNode head,ListNode end){
        if (head==end||head.next==end||head.next.next==end) return head;
        // 将小于划分点的值存储在临时链表中
        ListNode tmpHead=new ListNode(-1);
        // partition为划分点，p为链表指针，tp为临时链表指针
        ListNode partition=head.next,p=partition,tp=tmpHead;
        // 将小于划分点的结点放到临时链表中
        while (p.next!=end){
            if (p.next.val<partition.val){
                tp.next=p.next;
                tp=tp.next;
                p.next=p.next.next;
            }else {
                p=p.next;
            }
        }
        // 合并临时链表和原链表，将原链表接到临时链表后面即可
        tp.next=head.next;
        // 将临时链表插回原链表，注意是插回！（不做这一步在对右半部分处理时就断链了）
        head.next=tmpHead.next;
        quickSort(head,partition);
        quickSort(partition,end);
        // 题目要求不带头节点，返回结果时去除
        return head.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null||head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        return quicksort(dummy,null);
    }

    private ListNode quicksort(ListNode head, ListNode end) {
        if(head == end||head.next == end||head.next.next == end){
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        // 保留头节点
        ListNode a = small;
        ListNode b = big;
        ListNode patition = head.next;
        ListNode p = patition.next;
        while (p!=null){
            if(p.val<patition.val){
                small.next = p;
                small = small.next;
            }else {
                big.next = p;
                big = big.next;
            }
            p = p.next;
        }
        small.next = patition;
        patition.next = b.next;
        b.next = null;
        head.next = a.next;
        a.next = null;
        quicksort(head,patition);
        quicksort(patition,end);
        return head.next;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        排序链表 l = new 排序链表();
        ListNode listNode = l.sortList(a);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }

    }

}
