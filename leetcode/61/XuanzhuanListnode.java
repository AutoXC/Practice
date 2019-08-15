package no61;

import java.util.ArrayList;

public class XuanzhuanListnode {
    public static void main(String[] args) {
        
    }
    
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0||head.next==null) return head;
        ArrayList<ListNode> temp = new ArrayList<ListNode>();
        while(head!=null) {
            temp.add(head);
            head = head.next;
        }
        k %= temp.size();
        if(k==0) return temp.get(0);
        else {
            temp.get(temp.size()-1).next = temp.get(0);
            temp.get(temp.size()-k-1).next = null;
        }
        
        return temp.get(temp.size()-k);
    }
    
}
