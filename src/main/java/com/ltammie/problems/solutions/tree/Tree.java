package com.ltammie.problems.solutions.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Node root;

    public Tree() {
    }

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * @No 589
     * N-ary Tree Preorder Traversal
     */
    public List<Integer> preorder(Node root) {
        List<Integer> values = new ArrayList<>();
        if (root == null)
            return values;

        values.add(root.val);
        if (!root.children.isEmpty()) {
            for (Node child : root.children) {
                values.addAll(preorder(child));
            }
        }
        return values;
    }
}
