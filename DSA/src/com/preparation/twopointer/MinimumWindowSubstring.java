package com.preparation.twopointer;

import java.util.HashMap;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
	    if (t.length() > s.length()) {
	        return "";
	    }
	    HashMap<Character, Integer> reqFreqMap = new HashMap<>();
	    fillFreqHashMap(reqFreqMap, t);
	    HashMap<Character, Integer> curFreqMap = new HashMap<>();
	    int requiredDistinctChar = reqFreqMap.size();
	    int distinctCharFound = 0;
	    int left = 0;
	    int right = 0;
	    int minStart = 0;
	    int minLength = Integer.MAX_VALUE;
	    while (right < s.length()) {
	        distinctCharFound = addCharacter(s.charAt(right),reqFreqMap,curFreqMap,
	        		distinctCharFound);
	        while (distinctCharFound == requiredDistinctChar) {
	            int currentWindowLength = right - left + 1;
	            if (currentWindowLength < minLength) {
	                minLength = currentWindowLength;
	                minStart = left;
	            }
	            distinctCharFound = removeCharacter(s.charAt(left),reqFreqMap,curFreqMap,
	            		distinctCharFound);
	            left++;
	        }
	        right++;
	    }
	    if (minLength == Integer.MAX_VALUE) {
	        return "";
	    }
	    return s.substring(minStart, minStart + minLength);
	}

	private int addCharacter(char curCh,HashMap<Character, Integer> reqFreqMap,
			HashMap<Character,Integer> curFreqMap,int distinctCharFound) {
	    if (!reqFreqMap.containsKey(curCh)) {
	        return distinctCharFound;
	    }
	    int currentFrequency = curFreqMap.getOrDefault(curCh, 0) + 1;
	    curFreqMap.put(curCh, currentFrequency);
	    if (currentFrequency == reqFreqMap.get(curCh)) {
	        distinctCharFound++;
	    }
	    return distinctCharFound;
	}

	private int removeCharacter(char curCh,HashMap<Character, Integer> reqFreqMap,
	        HashMap<Character, Integer> curFreqMap,int distinctCharFound) {
	    if (!reqFreqMap.containsKey(curCh)) {
	        return distinctCharFound;
	    }
	    int currentFrequency = curFreqMap.get(curCh);
	    if (currentFrequency == reqFreqMap.get(curCh)) {
	        distinctCharFound--;
	    }
	    if (currentFrequency == 1) {
	        curFreqMap.remove(curCh);
	    } else {
	        curFreqMap.put(curCh, currentFrequency - 1);
	    }
	    return distinctCharFound;
	}

	private void fillFreqHashMap(HashMap<Character, Integer> freqMap,String s) {
	    for (int i = 0; i < s.length(); i++) {
	        char curCh = s.charAt(i);
	        freqMap.put(curCh,freqMap.getOrDefault(curCh, 0) + 1);
	    }
	}

	public static void main(String[] args) {
		System.out.println(new MinimumWindowSubstring().minWindow("T", "T"));
	}
}
