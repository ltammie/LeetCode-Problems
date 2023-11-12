package com.ltammie.problems.blind75;

import java.util.*;

/**
 * @No 49
 * hashmap to store groups of anagrams
 * if some word is an anagram of some key -> add it to this key group
 * if not - put new key to map
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        map.put(strs[0], new LinkedList<>());

        for (int i = 1; i < strs.length; i++) {
            String word = strs[i];
            if (!addToMap(word, map))
                map.put(word, new LinkedList<>());
        }

        List<List<String>> res = new LinkedList<>();
        for (String key : map.keySet()) {
            List<String> list = new LinkedList<>();
            list.add(key);
            list.addAll(map.get(key));
            res.add(list);
        }
        return res;
    }

    private boolean addToMap(String word, Map<String, List<String>> map) {
        for (String key : map.keySet()) {
            if (isAnagram(key, word)) {
                List<String> value = map.get(key);
                value.add(word);
                map.replace(key, value);
                return true;
            }
        }
        return false;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;

        int[] aLetters = new int[26];
        for (int i = 0; i < a.length(); i++) {
            int index = a.charAt(i) - 'a';
            aLetters[index]++;
        }

        for (int i = 0; i < b.length(); i++) {
            int index = b.charAt(i) - 'a';
            if (aLetters[index] == 0)
                return false;
            aLetters[index]--;
        }
        return true;
    }

    public List<List<String>> groupAnagramsFast(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] frequencyArr = new char[26];
            for (int i = 0; i < s.length(); i++) {
                frequencyArr[s.charAt(i) - 'a']++;
            }
            String key = String.valueOf(frequencyArr);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
