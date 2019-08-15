package no61;

import java.util.LinkedList;

public class XuanzhuanListnode {
    public static void main(String[] args) {
        
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0) return head;
        LinkedList<ListNode> temp = new LinkedList<ListNode>();
        while(head!=null) {
            temp.addLast(head);
            head = head.next;
        }
        k %= temp.size();
        if(k==0) return temp.getFirst();
        while(k--!=0) {
            temp.addFirst(temp.removeLast());
        }
        for(int i = 0;i<temp.size();i++) {
            if(i==temp.size()-1) {temp.get(i).next=null;}
            temp.get(i).next = temp.get(i+1);
        }
        return temp.getFirst();
    }
    
    public ListNode rotateRight0(ListNode head, int k) {
        if(head==null||k==0) return head;
        int size = 0;
        ListNode temp = head;
        ListNode index = null;
        while(temp!=null) {
            size++;
            if(temp.next!=null) {index = temp;}
            temp = temp.next;
        }
        k %= size;
        if(k==0||size==1) return head;
        while(k--!=0) {
            head = index.next;
            index.next=null;
        }
        
    }
}
