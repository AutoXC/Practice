package no237;

public class DeletNode {
    public void deleteNode(ListNode node) {
        //无法删除尾节点
        if(node==null || node.next==null) {return;}
        
        while(node!=null) {
            node.val = node.next.val;
            if(node.next.next==null) {
                node.next = null;
            }
            node = node.next;
        }
    }
}
