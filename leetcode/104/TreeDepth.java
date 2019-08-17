package no104;

public class TreeDepth {
    public static void main(String[] args) {
        
    }
    
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        int ld = maxDepth(left)+1;
        int rd = maxDepth(right)+1;
        
        return ld>rd?ld:rd;
    }
}
