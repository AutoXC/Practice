package no141;

import java.util.ArrayList;

public class cycleListNode {
    public static void main(String[] args) {

    }
    
    public boolean hasCycle(ListNode head) {
        /*
         * 哈希
         */
        int pos = -1;
        ArrayList<ListNode> arr = new ArrayList<ListNode>();
        while(head!=null) {
            if(arr.contains(head)) {
                pos = arr.indexOf(head);
                return true;
            }else {arr.add(head);}
            head = head.next;
        }
        return false;
    }
    
    public boolean hasCycle0(ListNode head) {
        /*
         * 跑步追逐
         */
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
