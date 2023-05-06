package com.ltammie.problems.solutions.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackSolutions {

    /**
     * @No 735. Asteroid Collision
     */
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            return null;
        } else if (asteroids.length <= 1) {
            return asteroids;
        }

        Stack<Integer> stack = new Stack<>();

        int n = asteroids.length - 1;
        for (int i = n; i >= 0; i--) {
            int currentAsteroid = asteroids[i];

            if (stack.isEmpty() || currentAsteroid < 0)
                stack.push(currentAsteroid);
            else {
                boolean isSurvived = true; // keep track of current asteroid state

                // going to collide against all previous asteroids or meet another one moving right and survive
                // or be destroyed in the process
                while (!stack.isEmpty() && stack.peek() < 0) {
                    int peek = stack.peek();
                    if (Math.abs(peek) < currentAsteroid) { //currentAsteroid destroys the top-most one in stack
                        stack.pop();
                    } else if (Math.abs(peek) == currentAsteroid) { //currentAsteroid and the top-most one in stack are both destroyed
                        stack.pop();
                        isSurvived = false;
                        break;
                    } else { //currentAsteroid destroyed by a bigger top-most one in stack
                        isSurvived = false;
                        break;
                    }
                }
                if (isSurvived) // if currentAsteroid destroyed the whole stack and survived - we push it to the stack
                    stack.push(currentAsteroid);
            }
        }
        if (stack.isEmpty())
            return new int[]{};
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    /**
     * @No 150. Evaluate Reverse Polish Notation
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                switch (token) {
                    case ("+"):
                        stack.push(a + b);
                        break;
                    case ("-"):
                        stack.push(b - a);
                        break;
                    case ("*"):
                        stack.push(a * b);
                        break;
                    case ("/"):
                        stack.push(b / a);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    /**
     * @No 496. Next Greater Element I
     * @algo monotonic stack, hashmap
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < nums1.length; i++) {
            valueToIndexMap.put(nums1[i], i);
        }

        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            if (stack.isEmpty())
                continue;
            int current = nums2[i];
            if (current < stack.peek())
                stack.push(current);
            else {
                while (!stack.isEmpty() && stack.peek() < current) {
                    int pop = stack.pop();
                    if (valueToIndexMap.containsKey(pop)) {
                        int index = valueToIndexMap.get(pop);
                        ans[index] = current;
                    }
                }
                stack.push(current);
            }
        }
        return ans;
    }

    /**
     * @No 739. Daily Temperatures
     * @algo monotonic stack
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>(); // contains indexes for temperatures array
        int[] ans = new int[temperatures.length]; // {0, 0, 0, ..., 0 }

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > temperatures[stack.peek()]) {
                int top = stack.pop();
                ans[top] = i - top; // put the distance between two temperatures;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * @No 42. Trapping Rain Water
     * @algo monotonic stack
     */
    public int trap(int[] height) {
        int total = 0;
        Stack<Integer> stack = new Stack<>(); // contains indices of height array values

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int pop = stack.pop();
                if (stack.isEmpty())
                    break;
                int dist = (i - stack.peek()) - 1;
                int h = Math.min(height[i], height[stack.peek()]) - height[pop];
                total += dist * h;
            }
            stack.push(i);
        }

        return total;
    }

    /**
     * @No 84. Largest Rectangle in Histogram
     * @algo prev smaller, next smaller + monotonic stack
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[heights.length];
        int[] pse = new int[heights.length];
        Arrays.fill(nse, heights.length);
        Arrays.fill(pse, -1);
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int top = stack.pop();
                nse[top] = i;
            }
            if (!stack.isEmpty())
                pse[i] = stack.peek();
            stack.push(i);
        }

        int largestArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nse[i] - pse[i] - 1;
            largestArea = Math.max(largestArea, width * heights[i]);
        }

        return largestArea;
    }


    public int[] findNextGreaterIndexes(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[numbers.length];
        Arrays.fill(nge, -1);
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int top = stack.pop();
                nge[top] = i;
            }
            stack.push(i);
        }
        return nge;
    }

    public int[] findPreviousGreaterIndexes(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] pge = new int[numbers.length];
        Arrays.fill(pge, -1);
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] <= numbers[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pge[i] = stack.peek();
            }
            stack.push(i);
        }
        return pge;
    }
}
