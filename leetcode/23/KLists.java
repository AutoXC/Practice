package no23;

import java.util.ArrayList;
import java.util.Arrays;

public class KLists {
    public static void main(String[] args) {
        long start = System.nanoTime();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        
        ListNode ans = mergeKLists(new ListNode[]{l1,l2,l3});
        System.out.println(ans.val + "," + ans.next.val + "," + ans.next.next.val + "," + ans.next.next.next.val + ","
                + ans.next.next.next.next.val + "," + ans.next.next.next.next.next.val + ","
                + ans.next.next.next.next.next.next.val + ","+ ans.next.next.next.next.next.next.next.val + ",");

        long end = System.nanoTime();
        System.out.println(end - start);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len==0) {return null;}
        if (len==1) {return lists[0];}
        if (len==2) {return mergeTwoLists(lists[0], lists[1]);}
        
        int mid = len / 2;
        ListNode[] l = Arrays.copyOfRange(lists, 0, mid);
        ListNode[] r = Arrays.copyOfRange(lists, mid, len);
        
        ListNode lAns = mergeKLists(l);
        ListNode rAns = mergeKLists(r);
        return mergeTwoLists(lAns, rAns);
    }
    
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) {return l1;}
        else if(l1==null||l2==null) {return l1==null?l2:l1;}
        
        ArrayList<ListNode> ans = new ArrayList<ListNode>();
        
        while(l1!=null||l2!=null) {
            if(l2==null||(l1!=null&&l1.val<l2.val)) {
                ans.add(l1);
                l1 = l1.next;
            }else {
                ans.add(l2);
                l2 = l2.next;
            }
        }
        
        for(int i = 0;i<ans.size()-1;i++) {
            ans.get(i).next = ans.get(i+1);
        }
        return ans.get(0);
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) {return l1;}
        else if(l1==null||l2==null) {return l1==null?l2:l1;}
        
        ListNode temp = null;
        if(l1.val<=l2.val) {temp = l1;l1=l1.next;}
        else {temp = l2;l2=l2.next;}
        temp.next = null;
        ListNode ans = temp;//first node
        
        while(l1!=null||l2!=null) {
            if(l2==null||(l1!=null&&l1.val<l2.val)) {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
                temp.next = null;
            }else {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
                temp.next = null;
            }
        }
        
        return ans;
    }
}
