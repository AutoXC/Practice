package no230;

import java.util.ArrayList;
import java.util.List;

public class KthSamllElement {
    List<Integer> arr = new ArrayList<Integer>();
    int ans;
    int index;
    
    public int kthSmallest0(TreeNode root, int k) {
        /*
         * 缓存列表
         */
        search0(root);
        return arr.get(k-1);
    }
    
    public void search0(TreeNode root) {
        if(root==null) return;
        search0(root.left);
        arr.add(root.val);
        search0(root.right);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        index = 0;
        search(root,k);
        return ans;
    }
    
    public void search(TreeNode root,int k) {
        /*
         * 提前中止中序遍历
         */
        if(root==null) return;
        if(index!=k) {
            search(root.left,k);
            index++;
            if(index==k) ans = root.val;
            search(root.right,k);
        }
    }
}
