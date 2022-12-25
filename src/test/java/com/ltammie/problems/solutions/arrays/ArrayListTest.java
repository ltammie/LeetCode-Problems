package com.ltammie.problems.solutions.arrays;

import org.junit.jupiter.api.Test;

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
        int[] nums3 = new int[]{-10,12,-20,-8,15};
        int[] nums4 = new int[]{-2,0,10,-19,4,6,-8};
        int[] nums5 = new int[]{-20,8,-6,-14,0,-19,14,4};
        int[] nums6 = new int[]{0,0};

        assertTrue(array.checkIfExist(nums1));
        assertFalse(array.checkIfExist(nums2));
        assertTrue(array.checkIfExist(nums3));
        assertFalse(array.checkIfExist(nums4));
        assertTrue(array.checkIfExist(nums5));
        assertTrue(array.checkIfExist(nums6));
    }
}