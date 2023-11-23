package com.ltammie.problems.neetcode150.twopointers.easy;

/**
 * @No 125. Valid Palindrome
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String lowerCaseStr = s.toLowerCase() //remove A-Z
                .replaceAll("[^a-z0-9]", ""); // remove all non-alphanumeric characters (leave letters and numbers)

        int left = 0;
        int right = lowerCaseStr.length() - 1;

        while (left < right) {
            if (lowerCaseStr.charAt(left) != lowerCaseStr.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
