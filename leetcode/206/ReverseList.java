package no206;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) {return head;}
        ListNode former = null;
        ListNode latter = null;
        while(head!=null) {
            //former-->head-->latter
            latter = head.next;
            head.next = former;
            former = head;
            head = latter;
        }
        return former;
    }
    
    public ListNode reverseList0(ListNode head) {
        /*
         * 递归法
         */
        if (head == null || head.next == null) return head;
        ListNode p = reverseList0(head.next);
        head.next.next = head;//关键
        head.next = null;//保证最后一个元素指向null，中间元素指向null会被递归上层覆盖
        return p;
    }
}
