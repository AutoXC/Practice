package no236;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SameParent2 {
    /*
     * 递归
     *      如果在遍历的任何点上，左、右或中三个标志中的任意两个变为 true
     *      这意味着我们找到了节点 p 和 q 的最近公共祖先
     */
    private TreeNode ans;

    public SameParent2() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }
        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}

class Solution {
    /*
     * 父节点指针法
     *      先广度优先遍历 向字典中存入（子节点，父节点）键值对
     *      再用一个集合set存入p或q全部父节点，最后遍历另一节点的父节点与set匹配
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            
            TreeNode node = stack.pop();
            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();
        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}

class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isChildren(root.left,p)&&isChildren(root.left,q)){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(isChildren(root.right,p)&&isChildren(root.right,q)){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
    //判断一个节点是否是另外一个的子节点
    public boolean isChildren(TreeNode father,TreeNode children){
        if(father==children)    return true;
        if(father==null)    return false;
        return isChildren(father.left,children) || isChildren(father.right,children);
    }
}

class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
        注意p,q必然存在树内, 且所有节点的值唯一!!!
        递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
        表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
        1. 左右子树的返回值都不为null, 由于值唯一左右子树的返回值就是p和q, 此时root为LCA
        2. 如果左右子树返回值只有一个不为null, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为LCA
        3. 左右子树返回值均为null, p和q均不在树中, 返回null
        **/
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}