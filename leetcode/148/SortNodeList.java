package no148;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortNodeList {
    public static void main(String[] args) {
        
    }
    
    public ListNode sortList0(ListNode head) {
        /*
         * 归并
         */
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //保证slow走到中间位置
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList0(head);
        ListNode right = sortList0(tmp);
        
        ListNode h = new ListNode(0);
        ListNode res = h;//res指向listnode(0),h去移动
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
    
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) {return head;}
        
        ArrayList<ListNode> arr = new ArrayList<ListNode>();
        while(head!=null) {
            arr.add(head);
            head = head.next;
        }
        sortArr(arr, 0, arr.size());
        for(int i = 0;i<arr.size();i++) {
            if(i==arr.size()-1) {
                arr.get(i).next=null;
                break;
            }
            arr.get(i).next=arr.get(i+1);
        }
        return arr.get(0);
    }
    
    public void sortArr(ArrayList<ListNode> arr,int start, int end) {
        /*
         * 原地快排
         */
        if(arr==null||arr.size()<2) {return;}
        if(start>=end||start==end-1) {return;}
        
        int standard = arr.get(end-1).val;
        int index = start;
        for(int i = start;i<end;i++) {
            if(arr.get(i).val<standard) {
                if(i!=index) {
                    Collections.swap(arr, index, i);
                }
                index++;
            }
        }
        
        Collections.swap(arr, index, end-1);
        
        if(index>start) {
            sortArr(arr, start, index);
        }
        if(index<end-1) {
            sortArr(arr, index + 1, end);
        }
    }
}
