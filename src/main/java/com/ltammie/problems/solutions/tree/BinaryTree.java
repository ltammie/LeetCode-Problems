package com.ltammie.problems.solutions.tree;

import java.util.*;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * @No 102 Binary Tree Level Order Traversal
     * @algo bfs
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();
                if (top != null) {
                    l.add(top.val);
                    if (top.left != null)
                        q.offer(top.left);
                    if (top.right != null)
                        q.offer(top.right);
                }

            }
            list.add(l);
        }
        return list;
    }

    /**
     * @No 617. Merge Two Binary Trees
     * @algo dfs
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        root1.val = root1.val + root2.val;
        root1.left =  mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /**
     * @No 116 Populating Next Right Pointers in Each Node
     * @algo bfs
     */
    public TreeNode connect(TreeNode root) {
        if (root == null)
            return null;

        TreeNode level = root;
        while (level != null) {
            TreeNode current = level;
            while (current != null) {
                if (current.left != null)
                    current.left.next = current.right;
                if (current.right != null && current.next != null)
                    current.right.next = current.next.left;

                current = current.next;
            }
            level = level.left;
        }
        return root;
    }

    /**
     * @No 98 Validate Binary Search Tree
     * @algo dfs inorder
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (previous != null && root.val <= previous.val)
                return false;
            previous = root;
            root = root.right;
        }
        return true;
    }

    /**
     * @No 235 Lowest Common Ancestor of a Binary Search Tree
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
