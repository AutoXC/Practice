package no235;

public class SameParent {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
         * 递归
         */
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
    
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        /*
         * 迭代
         */
        int pVal = p.val;
        int qVal = q.val;
        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
}