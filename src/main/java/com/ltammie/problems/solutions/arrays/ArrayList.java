package com.ltammie.problems.solutions.arrays;

import java.util.*;

public class ArrayList {

    public ArrayList() {
    }

    /**
     * @No 1827. Minimum Operations to Make the Array Increasing
     */
    public int minOperations(int[] nums) {
        if (nums.length == 1)
            return 0;

        int minOperations = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev >= nums[i]) {
                minOperations += prev + 1 - nums[i];
                prev++;
            } else {
                prev = nums[i];
            }
        }
        return minOperations;
    }

    /**
     * @No 118 Pascal's Triangle
     * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
     * [1]
     * [1,1]
     * [1,2,1]
     * [1,3,3,1]
     * [1,4,6,4,1]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new LinkedList<>();

        Integer[] lastRow = new Integer[0];
        while (numRows > 0) {
            Integer[] currentRow = new Integer[lastRow.length + 1];
            int prev = 0;
            for (int i = 0; i < lastRow.length; i++) {
                currentRow[i] = lastRow[i] + prev;
                prev = lastRow[i];
            }
            currentRow[currentRow.length - 1] = 1;
            triangle.add(Arrays.asList(currentRow));
            lastRow = currentRow;
            numRows--;
        }
        return triangle;
    }


    /**
     * @No 88
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int insertIndex = m + n - 1;
        // substruct 1 from m and n to avoid IndexOutOfBoundsException when accessing last element of arrays
        m--;
        n--;

        while (insertIndex >= 0 && m >= 0 && n >= 0) {
            if (nums2[n] > nums1[m]) {
                nums1[insertIndex] = nums2[n];
                insertIndex--;
                n--;
            } else {
                nums1[insertIndex] = nums1[m];
                insertIndex--;
                m--;
            }
        }
        while (n >= 0) {
            nums1[insertIndex] = nums2[n];
            insertIndex--;
            n--;
        }
    }

    /**
     * @No 217
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> countSet = new HashSet<>();
        for (int num : nums) {
            if (!countSet.add(num))
                return true;
        }
        return false;
    }

    /**
     * @No 53
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int current = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            current += num;
            maxSum = Math.max(maxSum, current);

            //discard negative max because addicting negatives
            //does not make the result bigger
            if (current < 0) {
                current = 0;
            }
        }
        return maxSum;
    }


    /**
     * @No 27
     * in-place removal
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * @No 66
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    /**
     * @No 136
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int num : nums) {
            if (occurrences.containsKey(num)) {
                occurrences.remove(num);
            } else {
                occurrences.put(num, num);
            }
        }
        return occurrences.keySet().iterator().next();
    }

    /**
     * @No 26
     * array is sorted in non-decreasing order
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
        }
        return slow + 1;
    }

    /**
     * @No 35
     * binary search
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * @No 169
     * majority element
     * @algo hashmap to count occurrences
     */
    public int majorityElement(int[] array) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int num : array) {
            if (occurrences.containsKey(num))
                occurrences.replace(num, occurrences.get(num) + 1);
            else occurrences.put(num, 1);
        }

        return Collections.max(occurrences.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    /**
     * @No 169
     * majority element
     * @algo sorting and return element at array.length/2
     */
    public int majorityElementSort(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }

    /**
     * @No 414
     * Third Maximum Number
     */
    public int thirdMax(int[] nums) {
        int[] distinct = Arrays.stream(nums).distinct().toArray();
        Arrays.sort(distinct);
        if (distinct.length < 3)
            return distinct[distinct.length - 1];
        return distinct[distinct.length - 3];
    }

    /**
     * @No 1346
     * 1346. Check If N and Its Double Exist
     * @algo binarySearch
     */
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int zeros = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (zeros == 2)
                    return true;
                zeros++;
                continue;
            }
            int x = binarySearch(arr, 0, arr.length - 1, arr[i] * 2);
            if (x != -1) {
                if (x != i && arr[x] / 2 == arr[i])
                    return true;
            }
            int y = binarySearch(arr, 0, arr.length - 1, arr[i] / 2);
            if (y != -1) {
                if (y != i && arr[y] * 2 == arr[i])
                    return true;
            }
        }
        return zeros == 2;
    }

    /**
     * @param arr    array to be searched
     * @param low    lower bound of the array
     * @param high   higher bound of the array
     * @param target number to be searched in the array
     * @return index of the found number of -1 if nothing found
     */
    public int binarySearch(int[] arr, int low, int high, int target) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                return binarySearch(arr, mid + 1, high, target);
            return binarySearch(arr, low, mid - 1, target);
        }
        return -1;
    }

    /**
     * @No 2099
     * Find Subsequence of Length K With the Largest Sum
     */
    public int[] maxSubsequence(int[] nums, int k) {
        //todo
        return null;
    }

    /**
     * @No 1480
     * Running Sum of 1d Array
     */
    public int[] runningSum(int[] nums) {
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            nums[i] = currentSum;
        }
        return nums;
    }

    /**
     * @No 724
     * Find Pivot Index
     */
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == total - leftSum - nums[i])
                return i;
            leftSum += nums[i];
        }
        return -1;
    }

    /**
     * @No 977
     * Squares of a Sorted Array
     */
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int low = 0;
        int high = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[low]) >= Math.abs(nums[high])) {
                res[i] = nums[low] * nums[low];
                low++;
            } else {
                res[i] = nums[high] * nums[high];
                high--;
            }
        }
        return res;
    }

    /**
     * @No 189
     * Rotate Array
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * @No 283
     * Move zeroes to the end of the array
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    /**
     * @No 167
     * Two Sum II - Input Array Is Sorted
     * @algo two-pointer
     * if current sum is smaller than a target -> move closer to the right
     * if current sum is higher than a target -> move closer to the left
     */

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target)
                left++;
            else right--;
        }

        return new int[]{left + 1, right + 1};
    }

    /**
     * @No 344
     * reverse a string
     */
    public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }

    /**
     * @No 557
     * reverse words in string
     */
    public String reverseWords(String s) {
        if (s == null)
            return null;
        char[] chars = s.toCharArray();
        int wordStartIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, wordStartIndex, i - 1);
                wordStartIndex = i + 1;
            }
        }
        //revers last word
        reverse(chars, wordStartIndex, chars.length - 1);
        return new String(chars);
    }

    /**
     * @No 205
     * @algo two maps
     */

    public boolean isIsomorphic(String s, String t) {
        int[] mapST = new int[256];
        int[] mapTS = new int[256];
        Arrays.fill(mapST, -1);
        Arrays.fill(mapTS, -1);

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mapST[c1] == -1 && mapTS[c2] == -1) {
                mapST[c1] = c2;
                mapTS[c2] = c1;
            } else if (!(mapST[c1] == c2 && mapTS[c2] == c1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @No 392
     * @algo two pointers
     */
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;
        if (t.isEmpty())
            return false;
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j == s.length())
                return true;
        }
        return false;
    }

    /**
     * @No 121 Best Time to Buy and Sell Stock
     * max sum
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            else if (price - minPrice > maxProfit)
                maxProfit = price - minPrice;
        }
        return maxProfit;
    }

    /**
     * @No 409
     */
    public int longestPalindrome(String s) {
        int[] pairs = new int[256];
        int length = 0;
        Arrays.fill(pairs, 0);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            pairs[c]++;
        }

        for (int pair : pairs) {
            length += pair / 2 * 2;
            if (pair % 2 == 1 && length % 2 == 0)
                length++;
        }
        return length;
    }

    /**
     * @No 3 Longest Substring Without Repeating Characters
     * @algo sliding window
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;
        if (s.length() == 1)
            return 1;

        // size of a sliding window
        int k = 1;
        int maxSize = 0;
        Set<Character> subSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < k; j++) {
                if (i + j == s.length())
                    break;
                if (subSet.contains(s.charAt(i + j))) {
                    maxSize = Math.max(subSet.size(), maxSize);
                    subSet.clear();
                    break;
                }
                else {
                    subSet.add(s.charAt(i + j));
                    k++;
                }
            }
        }
        return maxSize;
    }

    /** @No 3
     * @algo sliding window
     * off solution, left for reference
     */
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>(); // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; j++) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(map.get(s.charAt(j)), i);
//            }
//            ans = Math.max(ans, j - i + 1);
//            map.put(s.charAt(j), j + 1);
//        }
//        return ans;
//    }

    /**
     * @No 567 Permutation in String
     * @algo
     * s1 and s2 consist of lowercase English letters
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    /**
     * @No 733 Flood Fill
     * @algo BFS
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        int oldColor = image[sr][sc];

        int rowSize = image.length;
        int columnSize = image[0].length;
        while (!q.isEmpty()) {
            Pair current = q.poll();
            if (image[current.x][current.y] == oldColor)
                image[current.x][current.y] = color;
            if (current.x + 1 < rowSize && image[current.x + 1][current.y] == oldColor)
                q.offer(new Pair(current.x + 1, current.y));
            if (current.x - 1 >= 0 && image[current.x - 1][current.y] == oldColor)
                q.offer(new Pair(current.x - 1, current.y));
            if (current.y + 1 < columnSize && image[current.x][current.y + 1] == oldColor)
                q.offer(new Pair(current.x, current.y + 1));
            if (current.y - 1 >= 0 && image[current.x][current.y - 1] == oldColor)
                q.offer(new Pair(current.x, current.y - 1));
        }
        return image;
    }

    /**
     * @No 695 Max Area of Island
     * @algo BFS
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == 1)
                    maxArea = Math.max(maxArea, calculateArea(grid, y, x));
            }
        }
        return maxArea;
    }

    public int calculateArea(int[][] image, int sr, int sc) {
        int rowSize = image.length;
        int columnSize = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        image[sr][sc] = 0;

        int area = 0;
        while (!q.isEmpty()) {
            Pair top = q.poll();
            area++;
            if (top.x + 1 < rowSize && image[top.x + 1][top.y] != 0) {
                q.offer(new Pair(top.x + 1, top.y));
                image[top.x + 1][top.y] = 0;
            }
            if (top.x - 1 >= 0 && image[top.x - 1][top.y] != 0) {
                q.offer(new Pair(top.x - 1, top.y));
                image[top.x - 1][top.y] = 0;
            }
            if (top.y + 1 < columnSize && image[top.x][top.y + 1] != 0) {
                q.offer(new Pair(top.x, top.y + 1));
                image[top.x][top.y + 1] = 0;
            }
            if (top.y - 1 >= 0 && image[top.x][top.y - 1] != 0) {
                q.offer(new Pair(top.x, top.y - 1));
                image[top.x][top.y - 1] = 0;
            }
        }
        return area;
    }

    /**
     * @No 200 Number of Islands
     */
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == '1') {
                    floodFill(grid, y, x, '2');
                    numberOfIslands += 1;
                }
            }
        }
        return numberOfIslands;
    }

    public void floodFill(char[][] grid, int sr, int sc, char color) {
        if (grid[sr][sc] == color)
            return;
        int[] directions = {0, 1, 0, -1, 0};
        int oldColor = grid[sr][sc];

        Queue<Pair> q = new LinkedList<>();
        // mark as visited and add to queue
        grid[sr][sc] = color;
        q.offer(new Pair(sr, sc));

        int rowSize = grid.length;
        int columnSize = grid[0].length;
        while (!q.isEmpty()) {
            Pair current = q.poll();
            for (int i = 0; i < 4; i++) {
                Pair dir = new Pair(
                        current.x + directions[i],
                        current.y + directions[i + 1]);
                if (dir.x < 0 || dir.x == rowSize || dir.y < 0 || dir.y == columnSize ||
                        grid[dir.x][dir.y] != oldColor)
                    continue;
                // mark as visited and add to queue
                grid[dir.x][dir.y] = color;
                q.offer(dir);
            }
        }
    }

    private boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }

    /**
     * Returns min element in the given range of the array or 0 if array is empty
     *
     * @param array
     * @param start beginning of a range, inclusively
     * @param end   end of a range, exclusively
     * @return min
     */
    private int min(int[] array, int start, int end) {
        if (array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];

        int min = array[start];
        for (int i = start; i < end; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }

    /**
     * Returns min element in the array or 0 if array is empty
     *
     * @param array
     * @return min
     */
    private int min(int[] array) {
        return min(array, 0, array.length);
    }

    /**
     * Returns index of a min element in the array or -1 if array is empty
     *
     * @param array
     * @return min index
     */
    private int minIndex(int[] array) {
        if (array.length == 0)
            return -1;

        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[minIndex])
                minIndex = i;
        }
        return minIndex;
    }

    /**
     * Returns max element in the given range of the array or 0 if array is empty
     *
     * @param array
     * @param start beginning of a range, inclusively
     * @param end   end of a range, exclusively
     * @return max
     */
    private int max(int[] array, int start, int end) {
        if (array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];

        int max = array[start];
        for (int i = start; i < end; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    /**
     * Returns max element in the array or 0 if array is empty
     *
     * @param array
     * @return max
     */
    private int max(int[] array) {
        return max(array, 0, array.length);
    }

    /**
     * Returns index of a max element in the array or -1 if array is empty
     *
     * @param array
     * @return max index
     */
    private int maxIndex(int[] array) {
        if (array.length == 0)
            return -1;

        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }

    private void reverse(int[] array, int start, int end) {
        if (array == null)
            return;
        while (start < end) {
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }

    private void reverse(char[] array, int start, int end) {
        if (array == null)
            return;
        while (start < end) {
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }

    private class Pair {
        int x = 0;
        int y = 0;

        public Pair() {
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
