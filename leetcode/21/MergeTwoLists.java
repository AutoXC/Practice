package no21;

import java.util.ArrayList;

public class MergeTwoLists {
    public static void main(String[] args) {
        long start = System.nanoTime();
        
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode ans = mergeTwoLists(l1, l2);
        System.out.println(ans.val+","+ans.next.val+","+ans.next.next.val+","
                             +ans.next.next.next.val+","+ans.next.next.next.next.val+","+ans.next.next.next.next.next.val+",");
        
        long end = System.nanoTime();
        System.out.println(end-start);
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /* 
         * 原地工作&临时列表（注释中）
        */
        if(l1==null&&l2==null) {return l1;}
        else if(l1==null||l2==null) {return l1==null?l2:l1;}
        
//        ArrayList<ListNode> ans = new ArrayList<ListNode>();
        ListNode temp = null;
        if(l1.val<=l2.val) {temp = l1;l1=l1.next;}
        else {temp = l2;l2=l2.next;}
        temp.next = null;
        ListNode ans = temp;//first node
        
        while(l1!=null||l2!=null) {
            if(l2==null||(l1!=null&&l1.val<l2.val)) {
//                ans.add(l1);
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
                temp.next = null;
            }else {
//                ans.add(l2);
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
                temp.next = null;
            }
        }
        
//        for(int i = 0;i<ans.size()-1;i++) {
//            ans.get(i).next = ans.get(i+1);
//        }
//        return ans.get(0);
        return ans;
    }
}
