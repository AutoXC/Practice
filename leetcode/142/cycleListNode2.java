package no142;

import java.util.ArrayList;

public class cycleListNode2 {
    public static void main(String[] args) {
        
    }
    /*
     * Floyd 的算法被划分成两个不同的阶段
     * 在第一阶段，找出列表中是否有环，如果没有环，可以直接返回 null 并退出
     *      否则，用 相遇节点 来找到环的入口。
     * 第二阶段，给定阶段 1 找到的相遇点，阶段 2 将找到环的入口
     *      首先我们初始化额外的两个指针： ptr1 ，指向链表的头， ptr2 指向相遇点
     *      然后，我们每次将它们往前移动一步，直到它们相遇，它们相遇的点就是环的入口，返回这个节点。
     */
    public ListNode detectCycle(ListNode head) {
        /*
         * 哈希验证
         */
        int pos = -1;
        ArrayList<ListNode> arr = new ArrayList<ListNode>();
        while(head!=null) {
            if(arr.contains(head)) {
                pos = arr.indexOf(head);
                return head;
            }else {arr.add(head);}
            head = head.next;
        }
        return null;
    }
    
}
