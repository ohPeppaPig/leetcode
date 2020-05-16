package ListNode;

public class 分割链表 {

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode p = small;
        ListNode q = big;
        while(head!=null){
            if(head.val<x){
                p.next = head;
                p = p.next;
            }else{
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        p.next = big.next;
        q.next = null;
        return small.next;


    }
}
