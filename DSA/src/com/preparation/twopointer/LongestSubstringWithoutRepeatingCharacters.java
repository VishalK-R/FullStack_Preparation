package com.preparation.twopointer;

import java.util.HashMap;


public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * 
	 * For the string "abcabcbb", valid substrings include "abc", "bca", "cab", "bc", "cb", 
	 * and "b". The longest substring without repeating characters has a length of 3. 
	 * 
	 * A brute-force solution would take O(n²) time. We can improve this to O(n) 
	 * using a two-pointer sliding-window approach.
	 * 
	 * There are two common implementations. One uses a HashSet to keep track of the 
	 * characters currently in the window. The other uses a HashMap to store the latest 
	 * index of each character, allowing us to move the left pointer more efficiently 
	 * when we encounter a duplicate.
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int maxLength = 0;
        HashMap<Character,Integer> previouslyFoundCharIndexMap = new HashMap<>();
        while(end<s.length()) {
        	char ch = s.charAt(end);
        	if(previouslyFoundCharIndexMap.containsKey(ch)) {
        		start = Math.max(start, previouslyFoundCharIndexMap.get(ch) + 1);
        	}
        	maxLength = Math.max(maxLength,end-start+1);
        	

    		previouslyFoundCharIndexMap.put(ch, end);
    		end++;
        }
        return maxLength;
    }
}
