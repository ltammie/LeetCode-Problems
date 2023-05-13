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
        root1.left = mergeTrees(root1.left, root2.left);
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

    /**
     * @No 94. Binary Tree Inorder Traversal
     * @algo recursion
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Integer> res = new LinkedList<>();
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    /**
     * @No 94. Binary Tree Inorder Traversal
     * @algo stack
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     * @No 144. Binary Tree Preorder Traversal
     * @algo recursion
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Integer> res = new LinkedList<>();
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    /**
     * @No 144. Binary Tree Preorder Traversal
     * @algo stack
     */
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
        return res;
    }

    /**
     * @No 145. Binary Tree Postorder Traversal
     * @algo recursion
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Integer> res = new LinkedList<>();
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }

    /**
     * @No 104. Maximum Depth of Binary Tree
     * @algo bfs using queue
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int maxDepth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }

    /**
     * @No 993. Cousins in Binary Tree
     * @algo level-order BFS
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y)
            return false;
        boolean hitX = false;
        boolean hitY = false;
        int parentX = 0;
        int parentY = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty() && !hitX && !hitY) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    if (curr.left.val == x) {
                        hitX = true;
                        parentX = curr.val;
                    }
                    if (curr.left.val == y) {
                        hitY = true;
                        parentY = curr.val;
                    }
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    if (curr.right.val == x) {
                        hitX = true;
                        parentX = curr.val;
                    }
                    if (curr.right.val == y) {
                        hitY = true;
                        parentY = curr.val;
                    }
                    queue.offer(curr.right);
                }
            }
        }
        return hitX && hitY && parentX != parentY;
    }

    /**
     * @No 2331. Evaluate Boolean Binary Tree
     * @algo post-order traversal
     */
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null)
            return root.val != 0;

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        if (root.val == 2)
            return left | right;
        return left & right;
    }

    /**
     * @No 2236. Root Equals Sum of Children
     */
    public boolean checkTree(TreeNode root) {
        return root.left.val + root.right.val == root.val;
    }

    /**
     * @No 226. Invert Binary Tree
     * @algo bfs
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            swapChildren(curr);
            if (curr.left != null)
                queue.offer(curr.left);
            if (curr.right != null)
                queue.offer(curr.right);
        }
        return root;
    }

    /**
     * @No 100. Same Tree
     * @algo dfs
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;


        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right && p.val == q.val;
    }

    /**
     * @No 124. Binary Tree Maximum Path Sum
     * @algo postorder dfs + dynamic
     */
    public int maxPathSum(TreeNode root) {
        TreeNode maxPath = new TreeNode(Integer.MIN_VALUE);
        maxPathHelper(root, maxPath);
        return maxPath.val;
    }

    /**
     * Helper function for maxPathSum,
     *
     * @param root    current node
     * @param maxPath helper param to keep track of maxPath found so far
     * @return maxPath between left subtree and right subtree of the root node
     */
    private int maxPathHelper(TreeNode root, TreeNode maxPath) {
        if (root == null)
            return 0;
        int sumLeft = maxPathHelper(root.left, maxPath);
        int sumRight = maxPathHelper(root.right, maxPath);

        int maxWithRoot = Math.max(sumLeft + root.val, sumRight + root.val);
        int maxBetweenLeftRightSubtreesAndWholeSubtree = Math.max(maxWithRoot, sumLeft + root.val + sumRight);
        int subPathSum = Math.max(root.val, maxBetweenLeftRightSubtreesAndWholeSubtree);
        // update maxPath so far
        if (subPathSum > maxPath.val)
            maxPath.val = subPathSum;
        return Math.max(maxWithRoot, root.val); // if root.val is bigger then the value of root + any subtree
    }

    private void swapChildren(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
