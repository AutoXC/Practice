package no160;

import java.util.HashSet;

public class FindIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(headA!=null) {
            set.add(headA);
            headA = headA.next;
        }
        while(headB!=null) {
            if(set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    
    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        /*
         * 双指针法
         */
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
