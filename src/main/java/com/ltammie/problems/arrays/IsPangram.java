package com.ltammie.problems.arrays;

/**
 * @No 1832. Check if the Sentence Is Pangram
 * A pangram is a sentence where every letter of the English alphabet appears at least once
 */
public class IsPangram {
    public boolean checkIfPangram(String sentence) {
        char[] alphabet = new char[26];

        String lowerCaseStr = sentence.toLowerCase();

        for (int i = 0; i < lowerCaseStr.length(); i++) {
            int index = lowerCaseStr.charAt(i) - 'a';
            // handle numbers and other symbols
            if (index > 25 || index < 0)
                continue;
            alphabet[index]++;
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 0)
                return false;
        }

        return true;
    }
}


