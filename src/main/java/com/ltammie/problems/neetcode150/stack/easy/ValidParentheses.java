package com.ltammie.problems.neetcode150.stack.easy;

import java.util.Stack;

/**
 * @No 20. Valid Parentheses
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (!stack.isEmpty()) {
                if (stack.peek() == c) {
                    stack.pop();
                } else
                    return false;
            } else
                return false;
        }
        return stack.isEmpty();
    }
}