package com.ltammie.problems.solutions.arrays;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    void majorityElement() {
        ArrayList array = new ArrayList();
        int[] nums1 = new int[]{3, 2, 3};
        int[] nums2 = new int[]{2, 2, 1, 1, 1, 2, 2};
        int[] nums3 = new int[]{1};

        assertEquals(3, array.majorityElement(nums1));
        assertEquals(2, array.majorityElement(nums2));
        assertEquals(1, array.majorityElement(nums3));
    }

    @Test
    void majorityElementSort() {
        ArrayList array = new ArrayList();
        int[] nums1 = new int[]{3, 2, 3};
        int[] nums2 = new int[]{2, 2, 1, 1, 1, 2, 2};
        int[] nums3 = new int[]{1};
        int[] nums4 = new int[]{10, 2, 5, 4, 3, 7, 9, 0, 1, 8, 6};

        assertEquals(3, array.majorityElementSort(nums1));
        assertEquals(2, array.majorityElementSort(nums2));
        assertEquals(1, array.majorityElementSort(nums3));
        assertEquals(1, array.majorityElementSort(nums4));
    }

    @Test
    void thirdMax() {
        ArrayList array = new ArrayList();
        int[] nums1 = new int[]{3, 2, 1};
        int[] nums2 = new int[]{1, 2};
        int[] nums3 = new int[]{2, 2, 3, 1};
        int[] nums4 = new int[]{1, 2, 2, 5, 3, 5};

        assertEquals(1, array.thirdMax(nums1));
        assertEquals(2, array.thirdMax(nums2));
        assertEquals(1, array.thirdMax(nums3));
        assertEquals(2, array.thirdMax(nums4));
    }

    @Test
    void checkIfExist() {
        ArrayList array = new ArrayList();
        int[] nums1 = new int[]{10, 2, 5, 3};
        int[] nums2 = new int[]{3, 1, 7, 11};
        int[] nums3 = new int[]{-10, 12, -20, -8, 15};
        int[] nums4 = new int[]{-2, 0, 10, -19, 4, 6, -8};
        int[] nums5 = new int[]{-20, 8, -6, -14, 0, -19, 14, 4};
        int[] nums6 = new int[]{0, 0};

        assertTrue(array.checkIfExist(nums1));
        assertFalse(array.checkIfExist(nums2));
        assertTrue(array.checkIfExist(nums3));
        assertFalse(array.checkIfExist(nums4));
        assertTrue(array.checkIfExist(nums5));
        assertTrue(array.checkIfExist(nums6));
    }

    @Test
    void pivotIndex() {
        ArrayList array = new ArrayList();
        int[] nums1 = new int[]{1, 7, 3, 6, 5, 6};
        int[] nums2 = new int[]{1, 2, 3};
        int[] nums3 = new int[]{2, 1, -1};

        assertEquals(3, array.pivotIndex(nums1));
        assertEquals(-1, array.pivotIndex(nums2));
        assertEquals(0, array.pivotIndex(nums3));
    }

    @Test
    void sortedSquares() {
        ArrayList array = new ArrayList();
        int[] nums1 = new int[]{-4, -1, 0, 3, 10};
        int[] nums2 = new int[]{-7, -3, 2, 3, 11};

        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, array.sortedSquares(nums1));
        assertArrayEquals(new int[]{4, 9, 9, 49, 121}, array.sortedSquares(nums2));
    }

    @Test
    void moveZeroes() {
        ArrayList array = new ArrayList();
        int[] nums1 = new int[]{5, 3, 0, 3, 4, 0, 2, 7, 0, 5};
        int[] nums2 = new int[]{0, 1, 0, 3, 12};

        array.moveZeroes(nums1);
        array.moveZeroes(nums2);

        assertArrayEquals(new int[]{5, 3, 3, 4, 2, 7, 5, 0, 0, 0}, nums1);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums2);
    }

    @Test
    void twoSum() {
        ArrayList array = new ArrayList();
        int[] nums1 = new int[]{2, 7, 11, 15};
        int[] nums2 = new int[]{2, 3, 4};
        int[] nums3 = new int[]{-1, 0};
        int[] nums4 = new int[]{0, 0, 3, 4};

        assertArrayEquals(new int[]{1, 2}, array.twoSum(nums1, 9));
        assertArrayEquals(new int[]{1, 3}, array.twoSum(nums2, 6));
        assertArrayEquals(new int[]{1, 2}, array.twoSum(nums3, -1));
        assertArrayEquals(new int[]{1, 2}, array.twoSum(nums4, 0));
    }

    @Test
    void reverseWords() {
        ArrayList array = new ArrayList();
        String s1 = "Let's take LeetCode contest";
        String s2 = "God Ding";
        assertEquals("s'teL ekat edoCteeL tsetnoc", array.reverseWords(s1));
        assertEquals("doG gniD", array.reverseWords(s2));
    }

    @Test
    void isIsomorphic() {
        ArrayList array = new ArrayList();
        assertFalse(array.isIsomorphic("badc", "baba"));
        assertFalse(array.isIsomorphic("foo", "bar"));
    }

    @Test
    void isSubsequence() {
        ArrayList array = new ArrayList();
        assertTrue(array.isSubsequence("abc", "ahbgdc"));
        assertFalse(array.isSubsequence("axc", "ahbgdc"));
        assertTrue(array.isSubsequence("ace", "abcde"));
        assertFalse(array.isSubsequence("aec", "abcde"));
    }

    @Test
    void maxProfit() {
        ArrayList array = new ArrayList();
        assertEquals(5, array.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, array.maxProfit(new int[]{7, 6, 4, 3, 1}));
        assertEquals(2, array.maxProfit(new int[]{2, 4, 1}));
    }

    @Test
    void longestPalindrome() {
        ArrayList array = new ArrayList();
        assertEquals(7, array.longestPalindrome("abccccdd"));
        assertEquals(1, array.longestPalindrome("a"));
        assertEquals(1, array.longestPalindrome("ab"));
        assertEquals(3, array.longestPalindrome("abb"));
    }

    @Test
    void lengthOfLongestSubstring() {
        ArrayList array = new ArrayList();
        assertEquals(3, array.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, array.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, array.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void checkInclusion() {
        ArrayList array = new ArrayList();
        assertTrue(array.checkInclusion("aab", "eidabaoo"));
    }

    @Test
    void floodFill() {
        ArrayList array = new ArrayList();
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        array.floodFill(image, 1, 1, 2);
        assertArrayEquals(new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}}, image);
    }

    @Test
    void calculateArea() {
        ArrayList array = new ArrayList();
        int[][] image = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        array.maxAreaOfIsland(image);
        System.out.println();
    }

    @Test
    void containsDuplicateTest() {
        ArrayList array = new ArrayList();
        assertAll("",
                () -> assertTrue(array.containsDuplicate(new int[]{1, 2, 3, 1})),
                () -> assertFalse(array.containsDuplicate(new int[]{1, 2, 3, 4})),
                () -> assertTrue(array.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2})),
                () -> assertTrue(array.containsDuplicate(new int[]{0, 0})),
                () -> assertFalse(array.containsDuplicate(new int[]{}))
        );
    }

    @Test
    void maxSubArray() {
        ArrayList array = new ArrayList();
        assertAll("",
                () -> assertEquals(6, array.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})),
                () -> assertEquals(1, array.maxSubArray(new int[]{1})),
                () -> assertEquals(23, array.maxSubArray(new int[]{5, 4, -1, 7, 8})),
                () -> assertEquals(1, array.maxSubArray(new int[]{-2, 1}))
        );
    }

    @Test
    void merge() {
        ArrayList array = new ArrayList();

        assertAll("",
                () -> {
                    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
                    array.merge(nums1, 3, new int[]{2, 5, 6}, 3);
                    assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
                },
                () -> {
                    int[] nums1 = new int[]{1};
                    array.merge(nums1, 1, new int[]{}, 0);
                    assertArrayEquals(new int[]{1}, nums1);
                },
                () -> {
                    int[] nums1 = new int[]{0};
                    array.merge(nums1, 0, new int[]{1}, 1);
                    assertArrayEquals(new int[]{1}, nums1);
                },
                () -> {
                    int[] nums1 = new int[]{1, 2, 4, 6, 7, 0, 0, 0, 0, 0};
                    array.merge(nums1, 5, new int[]{3, 5, 8, 9, 10}, 5);
                    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, nums1);
                }
        );
    }

    @Test
    void generate() {
        ArrayList array = new ArrayList();
        List<List<Integer>> expected = new LinkedList<>();
        expected.add(List.of(1));
        expected.add(List.of(1, 1));
        expected.add(List.of(1, 2, 1));
        expected.add(List.of(1, 3, 3, 1));
        expected.add(List.of(1, 4, 6, 4, 1));

        assertEquals(expected, array.generate(5));
    }

    @Test
    void minOperations() {
        ArrayList array = new ArrayList();

        assertAll("",
                () -> assertEquals(3, array.minOperations(new int[]{1, 1, 1})),
                () -> assertEquals(14, array.minOperations(new int[]{1, 5, 2, 4, 1})),
                () -> assertEquals(0, array.minOperations(new int[]{8})),
                () -> assertEquals(19, array.minOperations(new int[]{1, 3, 7, 2, 8, 8, 1}))
        );
    }
}