package com.ltammie.problems.solutions

/**
 * @theme Top Interview Questions
 * @No 104
 */
fun maxDepth(root: TreeNode?): Int {
    if (root == null)
        return 0

    val depthLeft = maxDepth(root.left)
    val depthRight = maxDepth(root.right)
    if (depthLeft > depthRight)
        return depthLeft + 1
    return depthRight + 1
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}