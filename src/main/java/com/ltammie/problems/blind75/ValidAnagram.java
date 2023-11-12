package com.ltammie.problems.blind75;

public class ValidAnagram {

    /**
     * @No 242
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sLetters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sLetters[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (sLetters[index] == 0) {
                return false;
            }
            sLetters[index]--;
        }
        return true;
    }
}
