package ListNode;

public class 合并k有序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        if(lists.length ==2){
            return mergeTwoList(lists[0],lists[1]);
        }
        int mid = lists.length/2;
        ListNode[] l1 = new ListNode[mid];
        ListNode[] l2 = new ListNode[lists.length-mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }
        for(int i = mid,j=0; i < lists.length; i++,j++){
            l2[j] = lists[i];
        }
        // 分：就是递归
        ListNode node1 = mergeKLists(l1);
        ListNode node2 = mergeKLists(l2);
        return mergeTwoList(node1,node2);

    }
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
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
