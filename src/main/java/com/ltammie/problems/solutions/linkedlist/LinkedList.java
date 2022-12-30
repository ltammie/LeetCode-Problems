package com.ltammie.problems.solutions.linkedlist;

import java.util.*;

public class LinkedList {
    ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(ListNode head) {
        this.head = head;
    }

    public ListNode getHead() {
        return head;
    }

    public void add(int val) {
        if (head == null) {
            head = new ListNode(val);
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
    }

    public boolean contains(int val) {
        if (head == null)
            return false;

        ListNode current = head;
        while (current.next != null) {
            if (current.val == val)
                return true;
            current = current.next;
        }
        return false;
    }

    public void remove(int val) {
        if (head == null)
            return;
        if (head.val == val) {
            head = head.next;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
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
            } else {
                current = current.next;
            }
        }
        return head.val == val ? head.next : head;
    }

    /**
     * @No 876
     * @algo two pointer approach
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

    /**
     * @No 141
     */
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

    /**
     * @No 142
     * @algo two pointers
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * @No 21
     * list are sorted in non-decreasing order
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode resultHead = new ListNode();
        ListNode resultTail = resultHead;
        while (true) {
            if (curr1 == null) {
                resultTail.next = curr2;
                break;
            }
            if (curr2 == null) {
                resultTail.next = curr1;
                break;
            }
            if (curr1.val <= curr2.val) {
                resultTail.next = curr1;
                curr1 = curr1.next;
            } else {
                resultTail.next = curr2;
                curr2 = curr2.next;
            }
            resultTail = resultTail.next;
        }
        return resultHead.next;
    }

    /**
     * @No 83
     * The list is guaranteed to be sorted in ascending order.
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        Set<Integer> uniqueValues = new HashSet<>();
        ListNode current = head;
        while (current.next != null) {
            uniqueValues.add(current.val);
            if (uniqueValues.contains(current.next.val))
                current.next = current.next.next;
            else
                current = current.next;
        }
        return head;
    }

    /**
     * @No 234
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        Stack<Integer> stack = new Stack<>();

        ListNode current = head;
        while (current != null) {
            stack.add(current.val);
            current = current.next;
        }

        current = head;
        while (current.next != null) {
            int value = stack.pop();
            if (value != current.val)
                return false;
            current = current.next;
        }
        return true;
    }

    /**
     * @No 1290
     * The most significant bit is at the head of the linked list.
     * Each node's value is either 0 or 1.
     */
    public int getDecimalValue(ListNode head) {
        ListNode current = reverseList(head);
        int power = 0;
        int res = 0;
        while (current != null) {
            res += current.val << power;
            power++;
            current = current.next;
        }
        return res;
    }

    /**
     * @No 19
     * in one-pass
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        if (head.next == null && n > 0)
            return null;

        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode slow = tmpHead;
        ListNode fast = tmpHead;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return tmpHead.next;
    }
}
