package com.ltammie.problems.solutions.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @No 297. Serialize and Deserialize Binary Tree
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        LinkedList<String> data = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    data.add("null");
                    continue;
                }
                data.add(String.valueOf(curr.val));
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        while (Objects.equals(data.peekLast(), "null"))
            data.removeLast();
        return data.toString().replace(", ", ",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (Objects.equals(data, "[]"))
            return null;
        String[] nodeList = data
                .replace("[", "")
                .replace("]", "")
                .split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeList[0]));
        queue.offer(root);

        for (int i = 1; i < nodeList.length; i++) {
            TreeNode curr = queue.poll();
            if (!nodeList[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(nodeList[i]));
                queue.offer(curr.left);
            }
            if (i + 1 < nodeList.length && !nodeList[++i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nodeList[i]));
                queue.offer(curr.right);
            }

        }
        return root;
    }
}
