package com.ltammie.problems.solutions

/**
 * @theme Top Interview Questions
 * @No 160
 */
fun getIntersectionNode(headA:ListNode?, headB:ListNode?): ListNode? {
    if (headA == null || headB == null)
        return null

    val visited = HashMap<ListNode, Int>()

    var curr = headA
    /**
     * Traverse the first list and store visited nodes in a HashMap
     */
    while (curr != null) {
        visited[curr] = curr.`val`
        curr = curr.next
    }

    curr = headB
    /**
     * Traverse the second list and check if current node is in the HashMap
     * If so, then this is the intersecting node
     */
    while (curr != null) {
        if (visited.containsKey(curr))
            return curr
        curr = curr.next
    }
    return null
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}