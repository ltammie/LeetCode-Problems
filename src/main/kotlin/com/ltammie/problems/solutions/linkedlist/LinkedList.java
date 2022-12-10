package com.ltammie.problems.solutions.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LinkedList {
    ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(ListNode head) {
        this.head = head;
    }

    public void append(int val) {
        if (head == null) {
            head = new  ListNode(val);
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
    }

    /**
     * @No 206
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    /**
     * @No 203
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else current = current.next;
        }
        return head.val == val ? head.next : head;
    }

    /**
     * @No 876
     * two pointer approach
     */
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        Map<ListNode, Boolean> visitedNodes = new HashMap<>();
        ListNode current = head;
        while (current.next != null) {
            if (visitedNodes.containsKey(current.next))
                return true;
            visitedNodes.put(current.next, true);
            current = current.next;
        }
        return false;
    }

    public ListNode getHead() {
        return head;
    }
}
